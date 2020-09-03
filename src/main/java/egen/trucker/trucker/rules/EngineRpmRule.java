package egen.trucker.trucker.rules;
import egen.trucker.trucker.entity.Alert;
import egen.trucker.trucker.entity.Reading;
import egen.trucker.trucker.entity.Vehicle;
import egen.trucker.trucker.repository.AlertRepository;
import egen.trucker.trucker.repository.VehicleRepository;
import org.jeasy.rules.annotation.Action;
import org.jeasy.rules.annotation.Condition;
import org.jeasy.rules.annotation.Fact;
import org.jeasy.rules.annotation.Rule;
import org.jeasy.rules.core.BasicRule;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;


import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Optional;

@Rule(name = "High Engine RPM", description = "If engine rpm > redLine rpm")
@Component
public class EngineRpmRule extends BasicRule {
    @Autowired
    private VehicleRepository vehicleRepository;

    @Autowired
    private AlertRepository alertRepository;

    @Condition
    public boolean condition(@Fact("engineRpm") Reading reading) {

        Optional<Vehicle> existing = vehicleRepository.findByVin(reading.getVin());
        return existing.filter(vehicle -> reading.getEngineRpm() > vehicle.getRedlineRpm()).isPresent();
    }

    @Action
    public void action(@Fact("engineRpm") Reading reading) {
        Date date = new Date();
        SimpleDateFormat df = new SimpleDateFormat("YYYY-MM-DD hh:mm:ss.s");
        Alert alert = new Alert();
        alert.setVin(reading.getVin());
        alert.setPriority("HIGH");
        alert.setDescription("High Engine RPM");
        alert.setTimestamp(date);
        alertRepository.save(alert);
    }
}

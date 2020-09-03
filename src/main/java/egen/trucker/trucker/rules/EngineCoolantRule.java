package egen.trucker.trucker.rules;


import egen.trucker.trucker.entity.Alert;
import egen.trucker.trucker.entity.Reading;
import egen.trucker.trucker.entity.Vehicle;
import egen.trucker.trucker.repository.AlertRepository;
import egen.trucker.trucker.repository.VehicleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.jeasy.rules.annotation.Action;
import org.jeasy.rules.annotation.Condition;
import org.jeasy.rules.annotation.Fact;
import org.jeasy.rules.annotation.Rule;
import org.jeasy.rules.core.BasicRule;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Optional;

@Rule(name = "Engine Coolant Low / Engine Light On", description = "If engine coolant low || engine light on")
@Component
public class EngineCoolantRule extends BasicRule {
    @Autowired
    private VehicleRepository vehicleRepository;

    @Autowired
    private AlertRepository alertRepository;

    @Condition
    public boolean condition(@Fact("engineCoolant") Reading reading) {

        Optional<Vehicle> existing = vehicleRepository.findByVin(reading.getVin());
        return existing.filter(vehicle -> reading.isCheckEngineLightOn() || reading.isEngineCoolantLow()).isPresent();
    }

    @Action
    public void action(@Fact("engineCoolant") Reading reading) {
        Date date = new Date();
        SimpleDateFormat df = new SimpleDateFormat("YYYY-MM-DD hh:mm:ss.s");
        Alert alert = new Alert();
        alert.setVin(reading.getVin());
        alert.setPriority("LOW");
        alert.setDescription("Engine Coolant Low / Engine Light On");
        alert.setTimestamp(date);
        alertRepository.save(alert);
    }
}

package egen.trucker.trucker.service;


import egen.trucker.trucker.entity.Alert;
import egen.trucker.trucker.exception.AlertNotFoundException;
import egen.trucker.trucker.repository.AlertRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AlertServiceImpl implements AlertService{

    private final AlertRepository repository;

    @Autowired
    public AlertServiceImpl(AlertRepository repository) {
        this.repository = repository;
    }

    @Override
    public List<Alert> findAlertsByPriority(String priority) {
        Iterable<Alert> existing = repository.findByPriority(priority);
        if(!existing.iterator().hasNext()) {
            throw new AlertNotFoundException("Alerts for Vehicles with Priority:- "+priority+" not found");
        }
        return (List<Alert>) existing;
    }

    @Override
    public List<Alert> findAlertsByVin(String vin) {
        Iterable<Alert> existing = repository.findByVin(vin);
        if(!existing.iterator().hasNext()) {
            throw new AlertNotFoundException("Alerts for Vehicle with VIN:- "+vin+" not found");
        }
        return (List<Alert>) existing;
    }

    @Override
    public Alert create(Alert alert) {
        return repository.save(alert);
    }
}

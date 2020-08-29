package egen.trucker.trucker.service;


import egen.trucker.trucker.entity.Alert;

import java.util.List;

public interface AlertService {

    List<Alert> findAlertsByPriority(String priority);

    List<Alert> findAlertsByVin(String vin);

    Alert create(Alert alert);
}

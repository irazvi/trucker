package egen.trucker.trucker.service;


import egen.trucker.trucker.entity.Vehicle;

import java.util.List;

public interface VehicleService {

    List<Vehicle> findAll();

    Vehicle findOne(String vin);

    Vehicle create(Vehicle v);

    Iterable<Vehicle> update(List<Vehicle> vList);

    Vehicle delete(String vin);

}

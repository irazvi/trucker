package egen.trucker.trucker.repository;


import egen.trucker.trucker.entity.Vehicle;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;
@Repository
public interface VehicleRepository extends CrudRepository<Vehicle, String> {

    Optional<Vehicle> findByVin(String vin);
}

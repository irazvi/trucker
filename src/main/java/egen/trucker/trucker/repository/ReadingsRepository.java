package egen.trucker.trucker.repository;


import egen.trucker.trucker.entity.Reading;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface ReadingsRepository extends CrudRepository<Reading, String> {

}

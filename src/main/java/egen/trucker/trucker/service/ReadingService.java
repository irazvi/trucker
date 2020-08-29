package egen.trucker.trucker.service;


import egen.trucker.trucker.entity.Reading;

import java.util.List;

public interface ReadingService {

    List<Reading> findAll();

    Reading findOne(String id);

    Reading create(Reading reading);

}

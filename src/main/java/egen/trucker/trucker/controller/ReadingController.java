package egen.trucker.trucker.controller;


import egen.trucker.trucker.entity.Reading;
import egen.trucker.trucker.service.ReadingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/readings")
@CrossOrigin(origins = {"http://mocker.egen.academy"})
public class ReadingController {

    private final ReadingService service;

    @Autowired
    public ReadingController(ReadingService service) {
        this.service = service;
    }

    @RequestMapping(method = RequestMethod.GET,
    produces = MediaType.APPLICATION_JSON_VALUE)
    public List<Reading> findAll() {
        return service.findAll();
    }

    @RequestMapping(method = RequestMethod.POST,
            consumes = MediaType.APPLICATION_JSON_VALUE,
            produces = MediaType.APPLICATION_JSON_VALUE)
    public Reading create(@RequestBody Reading reading) {
        return service.create(reading);
    }
}

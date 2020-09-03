package egen.trucker.trucker.controller;


import egen.trucker.trucker.entity.Vehicle;
import egen.trucker.trucker.service.VehicleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/vehicles")
@CrossOrigin(origins = {"http://mocker.egen.academy"})
public class VehicleController {

    private final VehicleService service;

    @Autowired
    public VehicleController(VehicleService service) {
        this.service = service;
    }

    @RequestMapping(method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    public List<Vehicle> findAll() {
        return service.findAll();
    }

    @GetMapping(path = "/{vin}", produces = MediaType.APPLICATION_JSON_VALUE)
    public Vehicle findOne(@PathVariable String vin) {
        return service.findOne(vin);
    }

    @RequestMapping(method = RequestMethod.PUT,
            consumes = MediaType.APPLICATION_JSON_VALUE,
            produces = MediaType.APPLICATION_JSON_VALUE)
    public List<Vehicle> update(@RequestBody List<Vehicle> vList) {
        return (List<Vehicle>) service.update(vList);
    }

}

package com.aydinmustafa.springelasticsearch.controlller;

import com.aydinmustafa.springelasticsearch.model.Vehicle;
import com.aydinmustafa.springelasticsearch.search.SearchReqDto;
import com.aydinmustafa.springelasticsearch.service.VehicleService;
import com.aydinmustafa.springelasticsearch.service.helper.InsertInitialData;
import org.elasticsearch.action.search.SearchRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.web.bind.annotation.*;

import java.util.Date;
import java.util.List;

@RestController
@RequestMapping("/api/vehicle")
public class VehicleController {
    private final VehicleService service;
    private final InsertInitialData dummyDataService;

    @Autowired
    public VehicleController(VehicleService service, InsertInitialData dummyDataService) {
        this.service = service;
        this.dummyDataService = dummyDataService;
    }

    @PostMapping
    public void index(@RequestBody final Vehicle vehicle) {
        service.index(vehicle);
    }

    @PostMapping("/insertdummydata")
    public void insertDummyData() {
        dummyDataService.insertDummyData();
    }

    @GetMapping("/{id}")
    public Vehicle getById(@PathVariable final String id) {
        return service.getById(id);
    }

    @PostMapping("/search")
    public List<Vehicle> search(@RequestBody final SearchReqDto dto) {
        return service.search(dto);
    }

    @GetMapping("/search/{date}")
    public List<Vehicle> getAllVehiclesCreatedSince(
            @PathVariable
            @DateTimeFormat(pattern = "yyyy-MM-dd")
            final Date date) {
        return service.getAllVehiclesCreatedSince(date);
    }

    @PostMapping("/searchcreatedsince/{date}")
    public List<Vehicle> searchCreatedSince(
            @RequestBody final SearchReqDto dto,
            @PathVariable
            @DateTimeFormat(pattern = "yyyy-MM-dd")
            final Date date) {
        return service.searchCreatedSince(dto, date);
    }
}

package com.vodafone.controller;

import com.vodafone.VehicleStatusResponse;
import com.vodafone.service.GarageService;
import com.vodafone.VehicleInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/garage")
public class GarageController {

    @Autowired
    private GarageService garageService;

    @PostMapping("/park")
    public String parkCar(@RequestBody VehicleInfo car) {
        return garageService.parkCar(car);

    }

    @PostMapping("/leave")
    public Boolean leaveCar(@RequestBody VehicleInfo car) {
        return garageService.leaveCar(car);

    }

    @GetMapping("/status")
    public List<VehicleStatusResponse> status(){
        return garageService.getStatus();
    }
}

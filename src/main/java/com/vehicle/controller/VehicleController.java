package com.vehicle.controller;

import com.vehicle.dto.Vehicle;
import com.vehicle.service.VehicleService;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
@CrossOrigin
@RequestMapping("/vehicle")
public class VehicleController {

    private VehicleService vehicleService;
    public VehicleController(VehicleService vehicleService) {
        this.vehicleService = vehicleService;
    }

    @GetMapping("/{serviceYear}")
    public List<Vehicle> getVehiclesByServiceYear(@PathVariable String serviceYear){
        return vehicleService.getVehiclesByServiceYear(serviceYear);
    }

    @GetMapping("/type/{serviceId}")
    public Map<String, String> getVehicleTypeByServiceId(@PathVariable Long serviceId){
        return vehicleService.getVehicleTypeByServiceId(serviceId);
    }
    @DeleteMapping("/delete/{serviceYear}")
    public void deleteRecordsByServiceYear(@PathVariable String serviceYear){
        vehicleService.deleteRecordByServiceYear(serviceYear);
    }
}

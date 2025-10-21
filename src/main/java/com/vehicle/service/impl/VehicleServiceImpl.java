package com.vehicle.service.impl;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.vehicle.dao.RecordEntity;
import com.vehicle.dao.VehicleEntity;
import com.vehicle.dto.Record;
import com.vehicle.dto.Vehicle;
import com.vehicle.repository.RecordRepository;
import com.vehicle.repository.VehicleRepository;
import com.vehicle.service.VehicleService;
import jakarta.annotation.PostConstruct;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Map;

@Service
public class VehicleServiceImpl implements VehicleService {


    @Autowired
    RecordRepository recordRepository;
    @Autowired
    VehicleRepository vehicleRepository;
    @Autowired
    ObjectMapper objectMapper;

    @Override
    public void addRecords(Record record) {
        recordRepository.save(
                RecordEntity.builder()
                        .serviceYear(record.getServiceYear())
                        .vehicleEntity(
                                VehicleEntity.builder()
                                        .type(record.getVehicle().getType())
                                        .model(record.getVehicle().getModel())
                                        .registrationNo(record.getVehicle().getRegistrationNo())
                                        .build()
                        )
                        .build()
        );

    }

    @Override
    public List<Vehicle> getVehiclesByServiceYear(String serviceYear) {
        List<VehicleEntity> vehiclesByServiceYear = vehicleRepository.findVehiclesByServiceYear(serviceYear);
        List<Vehicle> vehicles = new ArrayList<Vehicle>();
        for(VehicleEntity vehicleEntity: vehiclesByServiceYear){
            vehicles.add(objectMapper.convertValue(vehicleEntity, Vehicle.class));
        }
        return vehicles;
    }

    @Override
    public Map<String, String> getVehicleTypeByServiceId(Long serviceId) {
        return Collections.singletonMap("Vehicle Type",vehicleRepository.findVehicleTypeByServiceId(serviceId));
    }

    @Override
    public void deleteRecordByServiceYear(String year) {
        vehicleRepository.deleteRecordsByServiceYear(year);
    }


    //To add sample data in initial run
    public void addSampleRecords() {

        // Vehicle 1
        Record r1 = Record.builder()
                .recordId(1L)
                .serviceYear("2023")
                .vehicle(Vehicle.builder()
                        .vehicleId(1L)
                        .registrationNo("MH12AB1234")
                        .type("Sedan")
                        .model("City")
                        .build())
                .build();
        addRecords(r1);

        // Vehicle 2
        Record r2 = Record.builder()
                .recordId(2L)
                .serviceYear("2023")
                .vehicle(Vehicle.builder()
                        .vehicleId(2L)
                        .registrationNo("MH14CD5678")
                        .type("SUV")
                        .model("Creta")
                        .build())
                .build();
        addRecords(r2);

        // Vehicle 3
        Record r3 = Record.builder()
                .recordId(3L)
                .serviceYear("2024")
                .vehicle(Vehicle.builder()
                        .vehicleId(3L)
                        .registrationNo("MH01EF9012")
                        .type("Hatchback")
                        .model("Swift")
                        .build())
                .build();
        addRecords(r3);

        // Vehicle 4
        Record r4 = Record.builder()
                .recordId(4L)
                .serviceYear("2024")
                .vehicle(Vehicle.builder()
                        .vehicleId(4L)
                        .registrationNo("MH09GH3456")
                        .type("SUV")
                        .model("Seltos")
                        .build())
                .build();
        addRecords(r4);

        // Vehicle 5
        Record r5 = Record.builder()
                .recordId(5L)
                .serviceYear("2025")
                .vehicle(Vehicle.builder()
                        .vehicleId(5L)
                        .registrationNo("MH20IJ7890")
                        .type("Sedan")
                        .model("Verna")
                        .build())
                .build();
        addRecords(r5);

        System.out.println("✅ Sample records added successfully!");
    }
    @PostConstruct
    public void loadSamples(){
        addSampleRecords();
    }
}

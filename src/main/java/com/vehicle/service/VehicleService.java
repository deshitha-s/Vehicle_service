package com.vehicle.service;

import com.vehicle.dto.Record;
import com.vehicle.dto.Vehicle;

import java.util.List;
import java.util.Map;

public interface VehicleService {
    public void addRecords(Record record);
    public List<Vehicle> getVehiclesByServiceYear(String serviceYear);
    public Map<String,String> getVehicleTypeByServiceId(Long serviceId);
    public void deleteRecordByServiceYear(String year);
}

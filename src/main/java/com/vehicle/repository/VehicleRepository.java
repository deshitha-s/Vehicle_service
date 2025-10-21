package com.vehicle.repository;

import com.vehicle.dao.VehicleEntity;
import jakarta.transaction.Transactional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface VehicleRepository extends JpaRepository<VehicleEntity, Long> {

    @Query("SELECT r.vehicleEntity FROM RecordEntity r WHERE r.serviceYear = :year")
    List<VehicleEntity> findVehiclesByServiceYear(@Param("year") String year);

    @Query("SELECT v.type FROM VehicleEntity v JOIN RecordEntity r ON v.vehicleId = r.vehicleEntity.vehicleId WHERE r.recordId = :serviceId")
    String findVehicleTypeByServiceId(@Param("serviceId") Long serviceId);

    @Transactional
    @Modifying
    @Query("DELETE FROM RecordEntity r WHERE r.serviceYear = :year")
    void deleteRecordsByServiceYear(@Param("year") String year);
}

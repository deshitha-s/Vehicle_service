package com.vehicle.repository;

import com.vehicle.dao.RecordEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface RecordRepository extends JpaRepository<RecordEntity, Long> {
}

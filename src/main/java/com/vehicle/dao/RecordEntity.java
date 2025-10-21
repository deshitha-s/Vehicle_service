package com.vehicle.dao;

import com.vehicle.dto.Vehicle;
import jakarta.persistence.*;
import jdk.jfr.Enabled;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.boot.autoconfigure.web.WebProperties;

@Entity
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class RecordEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long recordId;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name="vehicle_id")
    private VehicleEntity vehicleEntity;
    private String serviceYear;
}

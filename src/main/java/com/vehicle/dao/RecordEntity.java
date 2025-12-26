package com.vehicle.dao;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

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

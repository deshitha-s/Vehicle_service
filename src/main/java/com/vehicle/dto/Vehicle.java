package com.vehicle.dto;

import jakarta.persistence.Embeddable;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Embeddable
public class Vehicle {
    private Long vehicleId;
    private String registrationNo;
    private String type;
    private String model;
}

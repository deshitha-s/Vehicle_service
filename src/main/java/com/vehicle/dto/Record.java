package com.vehicle.dto;

import lombok.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Getter
@Setter
public class Record {
    private Long recordId;
    private Vehicle vehicle;
    private String serviceYear;
}

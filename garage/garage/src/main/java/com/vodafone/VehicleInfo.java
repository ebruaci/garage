package com.vodafone;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class VehicleInfo {
    private  String plateNumber;
    private  String color;
    private  VehicleEnum vehicleType;
}

package com.vodafone;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class Ticket {
    private  String id;
    private  VehicleInfo vehicleInfo;
    private int startSlot;
    private int endSlot;
}

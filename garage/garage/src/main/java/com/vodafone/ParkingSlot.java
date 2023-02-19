package com.vodafone;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor

public class ParkingSlot {
    private int number;
    private VehicleCaseType vehicleCaseType;
    private Ticket ticket;
}

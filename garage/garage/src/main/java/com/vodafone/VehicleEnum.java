package com.vodafone;

public enum VehicleEnum {
    CAR(1),
    JEEP(2),
    TRUCK(4);

    private int slots;

    private VehicleEnum(int slots) {
        this.slots = slots;
    }

    public int getSlots() {
        return slots;
    }
}

package com.vodafone.service;

import com.vodafone.*;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class GarageService {
    private final int MAX_SLOTS = 10;
    private List<ParkingSlot> parkingSlots;

    public String parkCar(VehicleInfo info) {
        if (parkingSlots == null) {
            createSlot();
        }

        long emptySlot = parkingSlots.stream().filter(x -> x.getVehicleCaseType().equals(VehicleCaseType.AVAILABLE)).count();
        if (emptySlot < info.getVehicleType().getSlots()) {
            return "Garage is full";
        }

        return slotCapacityControl(info);
    }

    private String slotCapacityControl(VehicleInfo info) {

        int startSlot = -1;
        int endSlot = -1;
        for (int i = 0; i < MAX_SLOTS; i++) {
            if (VehicleCaseType.AVAILABLE.equals(parkingSlots.get(i).getVehicleCaseType())
                    && canFit(info.getVehicleType().getSlots(), i)) {
                startSlot = i;
                endSlot = i + info.getVehicleType().getSlots();
                boolean canAllocate = true;

                for (int j = startSlot; j <= endSlot; j++) {
                    if (!VehicleCaseType.AVAILABLE.equals(parkingSlots.get(i).getVehicleCaseType())) {
                        canAllocate = false;
                        break;
                    }
                }
                if (canAllocate) {
                    for (int j = startSlot; j <= endSlot; j++) {
                        if (j == endSlot) {
                            parkingSlots.set(j, new ParkingSlot(j, VehicleCaseType.RESERVED, null));
                        } else {
                            String id = info.getPlateNumber() + "-" + info.getColor();
                            Ticket ticket = new Ticket(id, info, startSlot, endSlot);
                            parkingSlots.set(j, new ParkingSlot(j, VehicleCaseType.FULL, ticket));
                        }
                    }
                    return "Allocated " + info.getVehicleType().getSlots() + " slot.";
                }
            }
        }
        return "";
    }

    private void createSlot() {
        parkingSlots = new ArrayList<>(MAX_SLOTS);
        for (int i = 0; i < MAX_SLOTS; i++) {
            parkingSlots.add(new ParkingSlot(i + 1, VehicleCaseType.AVAILABLE, null));
        }
    }

    public boolean canFit(int width, int sayac) {
        if (sayac + width <= 10) {
            for (int i = sayac; i <= sayac + width; i++) {
                if (!VehicleCaseType.AVAILABLE.equals(parkingSlots.get(i).getVehicleCaseType())) {
                    return false;
                }
            }
            return true;
        }
        return false;
    }

    public Boolean leaveCar(VehicleInfo info) {
        String ticketId = info.getPlateNumber() + "-" + info.getColor();

        for (int i = 0; i < MAX_SLOTS; i++) {
            if (parkingSlots.get(i).getTicket() != null && ticketId.equals(parkingSlots.get(i).getTicket().getId())) {
                int startSlot = parkingSlots.get(i).getTicket().getStartSlot();
                int endSlot = parkingSlots.get(i).getTicket().getEndSlot();
                for (int j = startSlot; j <= endSlot; j++) {
                    parkingSlots.set(j, new ParkingSlot(j, VehicleCaseType.AVAILABLE, null));
                }
                return true;
            }
        }
        return false;
    }

    public List<VehicleStatusResponse> getStatus() {
        List<VehicleStatusResponse> vehicleStatusResponseList = new ArrayList<>();


        return vehicleStatusResponseList;
    }
}

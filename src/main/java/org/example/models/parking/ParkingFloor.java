package org.example.models.parking;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import org.example.models.vehicle.*;

import java.util.List;
import java.util.Optional;

@Getter
@Setter
@ToString
public class ParkingFloor {
    String name;
    List<ParkingSlot> parkingSlotList;

    public ParkingSlot getRelevantSlotForVehicleAndPark(Vehicle vehicle) {
        ParkingSlot parkingSlot = getRelevantSlotForVehicle(vehicle);
        if(parkingSlot == null) {
            return null;
        }
        parkingSlot.addVehicle(vehicle);
        return parkingSlot;
    }

    private ParkingSlot getRelevantSlotForVehicle(Vehicle vehicle) {
        ParkingSlotType parkingSlotType = getParkingSlotType(vehicle.getVehicleType());
        if(parkingSlotType == null) {
            return null;
        }
        Optional<ParkingSlot> parkingSlot = parkingSlotList.stream().filter(parkingSlot1 -> parkingSlotType.equals(parkingSlot1.getParkingSlotType()) && parkingSlot1.isAvailable()).findFirst();
        if(!parkingSlot.isPresent()) {
            return null;
        }
        return parkingSlot.get();
    }

    //TODO: Can we avoid adding to this switch case every time a new vehicle is added?
    private ParkingSlotType getParkingSlotType(VehicleType vehicleType) {
        ParkingSlotType parkingSlotType = null;
        switch (vehicleType) {
            case BUS:
                parkingSlotType = ParkingSlotType.BUS_SLOT;
                break;
            case TWO_WHEELER:
                parkingSlotType = ParkingSlotType.TWO_WHEELER_SLOT;
                break;
            case FOUR_WHEELER:
                parkingSlotType = ParkingSlotType.FOUR_WHEELER_SLOT;
                break;
        }
        return parkingSlotType;
    }

    public void addSlot(ParkingSlot parkingSlot) {
        parkingSlotList.add(parkingSlot);
    }

    public void removeSlot(ParkingSlot parkingSlot) {
        parkingSlotList.remove(parkingSlot);
    }
}

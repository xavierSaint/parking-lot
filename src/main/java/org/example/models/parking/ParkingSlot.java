package org.example.models.parking;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import org.example.models.vehicle.Vehicle;

@Getter
@Setter
@ToString
public abstract class ParkingSlot {
    String id;
    boolean isAvailable;
    Vehicle vehicle;
    ParkingSlotType parkingSlotType;

    public void addVehicle(Vehicle vehicle) {
        this.vehicle = vehicle;
        this.isAvailable = false;
    }

    public void removeVehicle() {
        this.vehicle = null;
        this.isAvailable = true;
    }
}

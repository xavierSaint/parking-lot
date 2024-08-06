package org.example.models.parking;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class BusParkingSlot extends ParkingSlot {
    public BusParkingSlot(){
        this.parkingSlotType = ParkingSlotType.BUS_SLOT;
        this.isAvailable = true;
    }
}

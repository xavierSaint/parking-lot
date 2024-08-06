package org.example.models.parking;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class FourWheelerParkingSlot extends ParkingSlot {
    public FourWheelerParkingSlot(){
        this.parkingSlotType = ParkingSlotType.FOUR_WHEELER_SLOT;
        this.isAvailable = true;
    }
}

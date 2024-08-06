package org.example.models.parking;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class TwoWheelerParkingSlot extends ParkingSlot {
    public TwoWheelerParkingSlot(){
        this.parkingSlotType = ParkingSlotType.TWO_WHEELER_SLOT;
        this.isAvailable = true;
    }
}

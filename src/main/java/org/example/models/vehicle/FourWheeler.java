package org.example.models.vehicle;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class FourWheeler extends Vehicle {
    public FourWheeler() {
        this.vehicleType = VehicleType.FOUR_WHEELER;
    }
}

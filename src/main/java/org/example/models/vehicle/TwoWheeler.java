package org.example.models.vehicle;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class TwoWheeler extends Vehicle {
    public TwoWheeler() {
        this.vehicleType = VehicleType.TWO_WHEELER;
    }
}

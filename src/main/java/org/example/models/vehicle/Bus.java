package org.example.models.vehicle;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Bus extends Vehicle{
    public Bus() {
        this.vehicleType = VehicleType.BUS;
    }
}

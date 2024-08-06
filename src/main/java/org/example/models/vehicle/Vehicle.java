package org.example.models.vehicle;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public abstract class Vehicle {
    String vehicleNumber;
    VehicleType vehicleType;
}

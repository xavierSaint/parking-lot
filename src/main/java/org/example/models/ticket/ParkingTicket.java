package org.example.models.ticket;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import org.example.models.parking.ParkingFloor;
import org.example.models.parking.ParkingSlot;

import java.time.LocalDateTime;

@Getter
@Setter
@ToString
public class ParkingTicket {
    LocalDateTime startTime;
    LocalDateTime endTime;
    String ticketId;
    ParkingSlot parkingSlot;
    ParkingFloor parkingFloor;
}

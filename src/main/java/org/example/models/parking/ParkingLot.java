package org.example.models.parking;

import com.google.inject.Singleton;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import org.example.models.address.Address;
import org.example.models.ticket.ParkingTicket;
import org.example.models.vehicle.Vehicle;

import java.time.LocalDateTime;
import java.time.temporal.ChronoUnit;
import java.util.List;

@Getter
@Setter
@Singleton
@ToString
public class ParkingLot {
    String name;
    Address address;
    List<ParkingFloor> parkingFloorList;
    private static ParkingLot parkingLot = null;

    private ParkingLot(String name, Address address, List<ParkingFloor> parkingFloorList){
        this.name = name;
        this.address = address;
        this.parkingFloorList = parkingFloorList;
    }

    public static ParkingLot getInstance(String name, Address address, List<ParkingFloor> parkingFloorList) {
        if (parkingLot == null) {
            parkingLot = new ParkingLot(name, address, parkingFloorList);
        }
        return parkingLot;
    }

    public ParkingTicket assignTicket(Vehicle vehicle) {
        ParkingTicket parkingTicket = null;

        for (ParkingFloor parkingFloor :parkingFloorList) {
            ParkingSlot parkingSlot =  parkingFloor.getRelevantSlotForVehicleAndPark(vehicle);
            if (parkingSlot != null) {
                parkingTicket = new ParkingTicket();
                parkingTicket.setStartTime(LocalDateTime.now());
                parkingTicket.setParkingSlot(parkingSlot);
                parkingTicket.setParkingFloor(parkingFloor);
                parkingTicket.setTicketId(parkingTicket.getParkingFloor().getName()+"_"+parkingSlot.getId()+"_"+vehicle.getVehicleNumber());
                break;
            }
        }
        return parkingTicket;
    }

    public double getAmountToPay(ParkingTicket parkingTicket) {
        parkingTicket.setEndTime(LocalDateTime.now());
        parkingTicket.getParkingSlot().removeVehicle();
        long seconds = ChronoUnit.SECONDS.between(parkingTicket.getStartTime(), parkingTicket.getEndTime());
        return parkingTicket.getParkingSlot().getParkingSlotType().getPrice(seconds);
    }

    public void addFloor(ParkingFloor parkingFloor) {
        parkingFloorList.add(parkingFloor);
    }

    public void removeFloor(ParkingFloor parkingFloor) {
        parkingFloorList.remove(parkingFloor);
    }
}

package org.example;

import org.example.models.address.Address;
import org.example.models.parking.*;
import org.example.models.ticket.ParkingTicket;
import org.example.models.vehicle.FourWheeler;
import org.example.models.vehicle.TwoWheeler;

import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) throws InterruptedException {
        Address address = Address.builder()
                .city("Bengaluru")
                .state("Karnataka")
                .country("India")
                .build();

        ParkingFloor parkingFloor1 = new ParkingFloor();
        parkingFloor1.setName("FLOOR-01");
        parkingFloor1.setParkingSlotList(getParkingSlotList());

        ParkingFloor parkingFloor2 = new ParkingFloor();
        parkingFloor2.setName("FLOOR-02");
        parkingFloor2.setParkingSlotList(getParkingSlotList());

        List<ParkingFloor> parkingFloorList = new ArrayList<>();
        parkingFloorList.add(parkingFloor1);
        parkingFloorList.add(parkingFloor2);

        ParkingLot parkingLot = ParkingLot.getInstance("Amazon Parking Lot", address, parkingFloorList);
        System.out.println(parkingLot);

        TwoWheeler twoWheeler1 = getTwoWheeler1();
        ParkingTicket parkingTicket1 = parkingLot.assignTicket(twoWheeler1);
        System.out.println(parkingTicket1);

        TwoWheeler twoWheeler2 = getTwoWheeler2();
        ParkingTicket parkingTicket2 = parkingLot.assignTicket(twoWheeler2);
        System.out.println(parkingTicket2);

        TwoWheeler twoWheeler3 = getTwoWheeler3();
        ParkingTicket parkingTicket3 = parkingLot.assignTicket(twoWheeler3);
        System.out.println(parkingTicket3);

        FourWheeler fourWheeler1 = getFourWheeler1();
        ParkingTicket parkingTicket4 = parkingLot.assignTicket(fourWheeler1);
        System.out.println(parkingTicket4);

        FourWheeler fourWheeler2 = getFourWheeler2();
        ParkingTicket parkingTicket5 = parkingLot.assignTicket(fourWheeler2);
        System.out.println(parkingTicket5);

        FourWheeler fourWheeler3 = getFourWheeler3();
        ParkingTicket parkingTicket6 = parkingLot.assignTicket(fourWheeler3);
        System.out.println(parkingTicket6);

        //sleep for 10 seconds;
        Thread.sleep(1000);
        System.out.println("Please pay: Rs " + parkingLot.getAmountToPay(parkingTicket1) + " for " + parkingTicket1);

        TwoWheeler twoWheeler4 = getTwoWheeler4();
        ParkingTicket parkingTicket7 = parkingLot.assignTicket(twoWheeler4);
        System.out.println(parkingTicket7);

        ParkingTicket parkingTicket8 = parkingLot.assignTicket(twoWheeler1);
        System.out.println(parkingTicket8);

        //sleep for 10 seconds;
        Thread.sleep(1000);
        System.out.println("Please pay: Rs " + parkingLot.getAmountToPay(parkingTicket2) + " for " + parkingTicket2);

        //sleep for 10 seconds;
        Thread.sleep(1000);
        System.out.println("Please pay: Rs " + parkingLot.getAmountToPay(parkingTicket3) + " for " + parkingTicket3);

        //sleep for 10 seconds;
        Thread.sleep(1000);
        System.out.println("Please pay: Rs " + parkingLot.getAmountToPay(parkingTicket4) + " for " + parkingTicket4);

        //sleep for 10 seconds;
        Thread.sleep(1000);
        System.out.println("Please pay: Rs " + parkingLot.getAmountToPay(parkingTicket5) + " for " + parkingTicket5);

        //sleep for 10 seconds;
        Thread.sleep(1000);
        System.out.println("Please pay: Rs " + parkingLot.getAmountToPay(parkingTicket6) + " for " + parkingTicket6);

        //sleep for 10 seconds;
        Thread.sleep(1000);
        System.out.println("Please pay: Rs " + parkingLot.getAmountToPay(parkingTicket7) + " for " + parkingTicket7);

        //sleep for 10 seconds;
        Thread.sleep(1000);
        System.out.println("Please pay: Rs " + parkingLot.getAmountToPay(parkingTicket8) + " for " + parkingTicket8);
    }

    private static FourWheeler getFourWheeler1() {
        FourWheeler fourWheeler = new FourWheeler();
        fourWheeler.setVehicleNumber("RJ829432");
        return fourWheeler;
    }

    private static FourWheeler getFourWheeler2() {
        FourWheeler fourWheeler = new FourWheeler();
        fourWheeler.setVehicleNumber("TN454321");
        return fourWheeler;
    }

    private static FourWheeler getFourWheeler3() {
        FourWheeler fourWheeler = new FourWheeler();
        fourWheeler.setVehicleNumber("KL014232");
        return fourWheeler;
    }

    private static TwoWheeler getTwoWheeler1() {
        TwoWheeler twoWheeler = new TwoWheeler();
        twoWheeler.setVehicleNumber("KA039109");
        return twoWheeler;
    }

    private static TwoWheeler getTwoWheeler4() {
        TwoWheeler twoWheeler = new TwoWheeler();
        twoWheeler.setVehicleNumber("JK039109");
        return twoWheeler;
    }

    private static TwoWheeler getTwoWheeler2() {
        TwoWheeler twoWheeler = new TwoWheeler();
        twoWheeler.setVehicleNumber("GJ450123");
        return twoWheeler;
    }

    private static TwoWheeler getTwoWheeler3() {
        TwoWheeler twoWheeler = new TwoWheeler();
        twoWheeler.setVehicleNumber("MP179323");
        return twoWheeler;
    }

    private static List<ParkingSlot> getParkingSlotList() {
        List<ParkingSlot> parkingSlotList = new ArrayList<>();
        parkingSlotList.add(getBusParkingSlot1());
        parkingSlotList.add(getTwoWheelerParkingSlot1());
        parkingSlotList.add(getFourWheelerParkingSlot1());
        parkingSlotList.add(getBusParkingSlot2());
        parkingSlotList.add(getTwoWheelerParkingSlot2());
        parkingSlotList.add(getFourWheelerParkingSlot2());
        return parkingSlotList;
    }

    private static ParkingSlot getBusParkingSlot1() {
        BusParkingSlot busParkingSlot = new BusParkingSlot();
        busParkingSlot.setId("BUS-01");
        return busParkingSlot;
    }

    private static ParkingSlot getTwoWheelerParkingSlot1() {
        TwoWheelerParkingSlot twoWheelerParkingSlot = new TwoWheelerParkingSlot();
        twoWheelerParkingSlot.setId("TWO-01");
        return twoWheelerParkingSlot;
    }

    private static ParkingSlot getFourWheelerParkingSlot1() {
        FourWheelerParkingSlot fourWheelerParkingSlot = new FourWheelerParkingSlot();
        fourWheelerParkingSlot.setId("FOUR-01");
        return fourWheelerParkingSlot;
    }

    private static ParkingSlot getBusParkingSlot2() {
        BusParkingSlot busParkingSlot = new BusParkingSlot();
        busParkingSlot.setId("BUS-02");
        return busParkingSlot;
    }

    private static ParkingSlot getTwoWheelerParkingSlot2() {
        TwoWheelerParkingSlot twoWheelerParkingSlot = new TwoWheelerParkingSlot();
        twoWheelerParkingSlot.setId("TWO-02");
        return twoWheelerParkingSlot;
    }

    private static ParkingSlot getFourWheelerParkingSlot2() {
        FourWheelerParkingSlot fourWheelerParkingSlot = new FourWheelerParkingSlot();
        fourWheelerParkingSlot.setId("FOUR-02");
        return fourWheelerParkingSlot;
    }
}
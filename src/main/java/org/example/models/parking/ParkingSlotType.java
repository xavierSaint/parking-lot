package org.example.models.parking;

public enum ParkingSlotType {
    TWO_WHEELER_SLOT{
        public double getPrice(long duration) {
            return 0.02 * duration;
        }
    },
    FOUR_WHEELER_SLOT{
        public double getPrice(long duration) {
            return 0.05 * duration;
        }
    },
    BUS_SLOT{
        public double getPrice(long duration) {
            return 0.1 * duration;
        }
    };

    public abstract double getPrice(long duration);
}

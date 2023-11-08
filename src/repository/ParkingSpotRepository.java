package repository;

import exception.ParkingSpotNotFoundException;
import models.ParkingSpot;

import java.util.HashMap;

public class ParkingSpotRepository {
    private HashMap<Integer, ParkingSpot> parkingSpotMap;

    public ParkingSpotRepository(){
        this.parkingSpotMap = new HashMap<>();
    }

    public ParkingSpot get(int parkingSpotId){
        ParkingSpot parkingSpot = parkingSpotMap.get(parkingSpotId);
        if(parkingSpot == null){
            throw new ParkingSpotNotFoundException("Parking Spot Not Found for :" + parkingSpot);
        }
        return parkingSpot;
    }

    public void put(ParkingSpot parkingSpot){
        parkingSpotMap.put(parkingSpot.getId(),parkingSpot);
    }

}

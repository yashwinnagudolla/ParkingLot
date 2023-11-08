package repository;

import exception.ParkingSpotNotFoundException;
import models.ParkingFloor;

import java.util.HashMap;
import java.util.Map;

public class ParkingFloorRepository {
    private Map<Integer, ParkingFloor> parkingFloorMap;

    public ParkingFloorRepository() {
        this.parkingFloorMap = new HashMap<>();
    }

    public ParkingFloor get(int parkingFloorId){
        ParkingFloor parkingFloor = parkingFloorMap.get(parkingFloorId);
        if(parkingFloor == null){
            throw new ParkingSpotNotFoundException("Parking floor not found for : "
                    + parkingFloor);
        }
        return parkingFloor;
    }

    public void put(ParkingFloor parkingFloor){
        parkingFloorMap.put(parkingFloor.getId(),parkingFloor);
    }
}

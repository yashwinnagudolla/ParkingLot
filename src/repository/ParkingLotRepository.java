package repository;

import exception.ParkingLotNotFoundException;
import models.Gate;
import models.ParkingLot;

import java.util.HashMap;
import java.util.Map;

public class ParkingLotRepository {
    private Map<Integer, ParkingLot> parkingLotMap;

    public ParkingLotRepository() {
        this.parkingLotMap = new HashMap<>();
    }

    public ParkingLot get(int parkingLotId){
        ParkingLot parkingLot = parkingLotMap.get(parkingLotId);
        if(parkingLot == null){
            throw new ParkingLotNotFoundException("Parking lot not found for : " + parkingLot);
        }
        return parkingLot;
    }

    public void put (ParkingLot parkingLot){
        parkingLotMap.put(parkingLot.getId(),parkingLot);
    }

    public ParkingLot getParkingLotFromGate(Gate gate){
        ParkingLot parkingLot = parkingLotMap.get(gate.getParkingLotId());
        if(parkingLot == null){
            throw new ParkingLotNotFoundException("Parking lot not found for the Gate : " + gate);
        }
        return parkingLot;

    }
}

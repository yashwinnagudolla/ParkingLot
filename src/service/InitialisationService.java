package service;

import models.*;
import repository.GateRepository;
import repository.ParkingFloorRepository;
import repository.ParkingLotRepository;
import repository.ParkingSpotRepository;

import java.util.ArrayList;
import java.util.List;

public class InitialisationService {
    private GateRepository gateRepository;
    private ParkingLotRepository parkingLotRepository;
    private ParkingFloorRepository parkingFloorRepository;
    private ParkingSpotRepository parkingSpotRepository;

    public ParkingLot initialise(){
        ParkingLot parkingLot = new ParkingLot();
        parkingLot.setId(0);
        parkingLot.setStatus(Status.ACTIVE);
        parkingLot.setAddress("Janda Street, Chittoor, AP, 517001");
        parkingLot.setCapacity(100);

        Gate entryGate = new Gate();
        entryGate.setId(1);
        entryGate.setOperator("Nishu");
        entryGate.setGateNumber(1);
        entryGate.setFloorNumber(1);
        entryGate.setStatus(Status.ACTIVE);
        entryGate.setParkingLotId(1);

        Gate exitGate = new Gate();
        exitGate.setId(2);
        exitGate.setOperator("Madhan");
        exitGate.setGateNumber(2);
        exitGate.setGateType(GateType.EXIT);
        exitGate.setFloorNumber(1);
        exitGate.setStatus(Status.ACTIVE);
        exitGate.setParkingLotId(1);

        parkingLot.setGates(List.of(entryGate,exitGate));
        gateRepository.put(entryGate);
        gateRepository.put(exitGate);

        List<ParkingFloor> parkingFloors = new ArrayList<>();

        for(int i = 1;i <= 10;i++){
            List<ParkingSpot> parkingSpots = new ArrayList<>();
            ParkingFloor parkingFloor = new ParkingFloor();
            parkingFloor.setId(100+i);
            parkingFloor.setStatus(Status.ACTIVE);
            parkingFloor.setFloorNumber(i);
            for(int j = 1;j <= 10;j++){
                ParkingSpot parkingSpot = new ParkingSpot();
                parkingSpot.setId(1000+j);
                parkingSpot.setNumber(i*100+j);
                if(j%2==0){
                    parkingSpot.setVehicleType(VehicleType.TWO_WHEELER);
                } else {
                    parkingSpot.setVehicleType(VehicleType.FOUR_WHEELER);
                }
                parkingSpot.setStatus(Status.AVAILABLE);
                parkingSpots.add(parkingSpot);
                parkingSpotRepository.put(parkingSpot);
            }
        }
        parkingLot.setParkingFloors(parkingFloors);
        parkingLotRepository.put(parkingLot);
        return parkingLot;
    }

}

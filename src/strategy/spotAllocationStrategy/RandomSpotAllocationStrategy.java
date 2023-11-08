package strategy.spotAllocationStrategy;

import exception.ParkingLotNotFoundException;
import models.*;
import repository.ParkingLotRepository;

public class RandomSpotAllocationStrategy implements SpotAllocationStrategy{
    private ParkingLotRepository parkingLotRepository;

    public RandomSpotAllocationStrategy(ParkingLotRepository parkingLotRepository) {
        this.parkingLotRepository = parkingLotRepository;
    }

    public ParkingSpot getSpot(Vehicle vehicle, Gate gate) {
        ParkingLot parkingLot = parkingLotRepository.getParkingLotFromGate(gate);
        int currentFloor = gate.getFloorNumber();
        ParkingFloor parkingFloor = parkingLot.getParkingFloors().get(currentFloor-1);
        for(ParkingSpot parkingSpot : parkingFloor.getParkingSpots()){
            if(parkingSpot.getStatus().equals(Status.AVAILABLE) && parkingSpot.getVehicleType().equals(vehicle.getVehicleType())){
                return parkingSpot;
            }
        }
        for(ParkingFloor parkingfloor : parkingLot.getParkingFloors()){
            for(ParkingSpot parkingSpot : parkingfloor.getParkingSpots()){
                if(parkingSpot.getVehicleType().equals(vehicle.getVehicleType()) && parkingSpot.getStatus().equals(Status.AVAILABLE)){
                    return parkingSpot;
                }
            }
        }
        throw new ParkingLotNotFoundException("No parking spot available for this vehicle type" + vehicle.getVehicleType().name());
    }

}
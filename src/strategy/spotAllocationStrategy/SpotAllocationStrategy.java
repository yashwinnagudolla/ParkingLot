package strategy.spotAllocationStrategy;

import models.Gate;
import models.ParkingSpot;
import models.Vehicle;

public interface SpotAllocationStrategy {
    public ParkingSpot getSpot(Vehicle vehicle, Gate gate);
}

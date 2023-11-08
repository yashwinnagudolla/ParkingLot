package strategy.feeCalculatorStrategy;

import models.Ticket;
import models.VehicleType;

import java.time.LocalDateTime;
import java.time.temporal.ChronoUnit;

public class LowFeeCalculationStrategy implements FeeCalculationStrategy{
    private static final int PER_MIN_RATE_2_WHEELER = 2;
    private static final int PER_MIN_RATE_4_WHEELER = 5;
    public LowFeeCalculationStrategy() {

    }

    public long getFeeAmount(Ticket ticket){
        LocalDateTime entryTime = ticket.getEntryTime();
        LocalDateTime currentTime = LocalDateTime.now();
        long numberOfMinutes = ChronoUnit.MINUTES.between(currentTime, entryTime);
        return (ticket.getVehicle().getVehicleType() == VehicleType.TWO_WHEELER)? numberOfMinutes*PER_MIN_RATE_2_WHEELER : numberOfMinutes*PER_MIN_RATE_4_WHEELER;

    }
}

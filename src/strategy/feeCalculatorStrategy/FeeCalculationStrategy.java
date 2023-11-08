package strategy.feeCalculatorStrategy;

import models.Ticket;

public interface FeeCalculationStrategy {
    long getFeeAmount(Ticket ticket);
}

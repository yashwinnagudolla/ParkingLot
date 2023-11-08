package strategy.feeCalculatorStrategy;

public class FeeCalculationStrategyFactory {
    public static FeeCalculationStrategy getFeeCalculationStrategy(){
        return new LowFeeCalculationStrategy();
    }
}

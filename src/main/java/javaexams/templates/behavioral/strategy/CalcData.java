package javaexams.templates.behavioral.strategy;

public class CalcData {

    private double x;
    private double y;

    public CalcData(double x, double y) {
        this.x = x;
        this.y = y;
    }

    private CalculationStrategy calculationStrategy;

    public void setCalculationStrategy(CalculationStrategy calculationStrategy) {
        this.calculationStrategy = calculationStrategy;
    }

    public double calculate() {
        return calculationStrategy.calculate(x, y);
    }
}

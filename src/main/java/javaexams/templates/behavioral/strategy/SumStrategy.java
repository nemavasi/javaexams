package javaexams.templates.behavioral.strategy;

public class SumStrategy implements CalculationStrategy {

    @Override
    public double calculate(double a, double b) {
        return a + b;
    }
}

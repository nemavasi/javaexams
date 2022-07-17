package javaexams.templates.structural.bridge;

public abstract class AbstractCar implements Car {

    private Motor motor;

    public AbstractCar(Motor motor) {
        this.motor = motor;
    }

    @Override
    public Motor motor() {
        return motor;
    }

    public abstract void go();
}

package javaexams.templates.structural.bridge;

public class CarSedan extends AbstractCar {

    public CarSedan(Motor motor) {
        super(motor);
    }

    @Override
    public void go() {
        motor().turnOn();
        System.out.println("sedan is going...");
    }
}

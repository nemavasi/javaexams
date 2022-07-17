package javaexams.templates.structural.bridge;

public class CarCabriolet extends AbstractCar {

    public CarCabriolet(Motor motor) {
        super(motor);
    }

    @Override
    public void go() {
        motor().turnOn();
        System.out.println("cabriolet is going ...");

    }
}

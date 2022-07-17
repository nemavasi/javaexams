package javaexams.templates.creational.factory_method;

public class CarLogistics extends Logistics{

    @Override
    public Transport createTransport() {
        return new Car();
    }
}

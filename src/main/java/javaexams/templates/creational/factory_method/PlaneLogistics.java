package javaexams.templates.creational.factory_method;

public class PlaneLogistics extends Logistics{

    @Override
    public Transport createTransport() {
        return new Plane();
    }
}

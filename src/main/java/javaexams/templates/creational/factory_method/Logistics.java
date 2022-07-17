package javaexams.templates.creational.factory_method;

public abstract class Logistics {

    public void planPath(){
        Transport transport = createTransport();
        transport.moveTo("Msk");
    }

    public abstract Transport createTransport();
}

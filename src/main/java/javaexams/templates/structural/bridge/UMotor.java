package javaexams.templates.structural.bridge;

public class UMotor implements Motor {

    @Override
    public void turnOn() {
        System.out.println("motor U is on");
    }

    @Override
    public void turnOff() {
        System.out.println("motor U is off");
    }
}

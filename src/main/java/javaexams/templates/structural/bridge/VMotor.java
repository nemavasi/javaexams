package javaexams.templates.structural.bridge;

public class VMotor implements Motor {

    @Override
    public void turnOn() {
        System.out.println("motor V is on");
    }

    @Override
    public void turnOff() {
        System.out.println("motor V is off");
    }
}

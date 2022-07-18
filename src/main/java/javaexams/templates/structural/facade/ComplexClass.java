package javaexams.templates.structural.facade;

public class ComplexClass implements ComplexInterface {

    @Override
    public void insertInSocket() {
        System.out.println("insertInSocket");
    }

    @Override
    public void turnOn() {
        System.out.println("turnOn");
    }

    @Override
    public void waitForOS() {
        System.out.println("waitForOS");
    }

    @Override
    public void login() {
        System.out.println("login");
    }

    @Override
    public void startProgram() {
        System.out.println("startProgram");
    }

    @Override
    public void waitForEnd() {
        System.out.println("waitForEnd");
    }

    @Override
    public void writeResults() {
        System.out.println("writeResults");
    }

    @Override
    public void turnOff() {
        System.out.println("turnOff");
    }

    @Override
    public void popFromSocket() {
        System.out.println("popFromSocket");
    }
}

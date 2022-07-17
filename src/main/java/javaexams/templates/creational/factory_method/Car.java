package javaexams.templates.creational.factory_method;

public class Car implements Transport{

    @Override
    public void moveTo(String cityName) {
        System.out.println("moving to " + cityName + " on the ground");
    }
}

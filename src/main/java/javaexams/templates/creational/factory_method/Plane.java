package javaexams.templates.creational.factory_method;

public class Plane implements Transport{
    
    @Override
    public void moveTo(String cityName) {
        System.out.println("moving to " + cityName + " in the sky");
    }
}

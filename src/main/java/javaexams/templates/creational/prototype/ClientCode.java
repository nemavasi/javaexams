package javaexams.templates.creational.prototype;

public class ClientCode {
    public void process(){
        Car prototypeCar = new Car();
        prototypeCar.setProducer("Toyota");
        prototypeCar.setName("Corolla");
        prototypeCar.setModel("E90");
        prototypeCar.setMotor("4A-GZE");

        Car myCar = prototypeCar.copyIt(); //!!!
        myCar.setMileage(45654);

        System.out.println(prototypeCar);
        System.out.println(myCar);

    }

    public static void main(String[] args) {
        new ClientCode().process();
    }
}

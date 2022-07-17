package javaexams.templates.structural.bridge;

public class ClientCode {

    public static void main(String[] args) {
        Car myCar = new CarSedan(new UMotor());
        myCar.go();
    }
}

//motor U is on
//sedan is going...
package javaexams.templates.factory_method;

public class ClientCode {

    public static void main(String[] args) {
        Logistics logistics = new CarLogistics();
        logistics.planPath();
    }
}

package javaexams.templates.creational.abstract_factory;

import java.util.HashMap;
import java.util.Map;
import javaexams.templates.creational.abstract_factory.ammd.AmmdComputerFactory;
import javaexams.templates.creational.abstract_factory.inttel.InttelComputerFactory;

public class ClientCode {

    private ComputerFactory computerFactory;


    public void init(Map<String, String> preferences) {
        if ("ammd".equalsIgnoreCase(preferences.get("pref_producer"))) {
            computerFactory = new AmmdComputerFactory();
        } else {
            computerFactory = new InttelComputerFactory();
        }
    }


    public void process() {
        Processor processor = computerFactory.createProcessor();
        Motherboard motherboard = computerFactory.createMotherboard();

        processor.printName();
        motherboard.printName();
    }

    public static void main(String[] args) {
        Map<String, String> prefs = new HashMap<>();
        prefs.put("pref_producer", "ammd");
        ClientCode clientCode = new ClientCode();
        clientCode.init(prefs);
        clientCode.process();

        System.out.println();

        prefs.put("pref_producer", "inttel");
        clientCode.init(prefs);
        clientCode.process();


    }
}

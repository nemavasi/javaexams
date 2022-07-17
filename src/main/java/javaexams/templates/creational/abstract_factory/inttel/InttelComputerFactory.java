package javaexams.templates.creational.abstract_factory.inttel;

import javaexams.templates.creational.abstract_factory.ComputerFactory;
import javaexams.templates.creational.abstract_factory.Motherboard;
import javaexams.templates.creational.abstract_factory.Processor;
import javaexams.templates.creational.abstract_factory.inttel.s1200.ASU8775690;
import javaexams.templates.creational.abstract_factory.inttel.s1200.ii3_7400;

public class InttelComputerFactory implements ComputerFactory {

    @Override
    public Processor createProcessor() {
        return new ii3_7400();
    }

    @Override
    public Motherboard createMotherboard() {
        return new ASU8775690();
    }
}

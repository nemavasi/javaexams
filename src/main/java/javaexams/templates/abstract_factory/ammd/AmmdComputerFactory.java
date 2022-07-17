package javaexams.templates.abstract_factory.ammd;

import javaexams.templates.abstract_factory.ComputerFactory;
import javaexams.templates.abstract_factory.Motherboard;
import javaexams.templates.abstract_factory.Processor;
import javaexams.templates.abstract_factory.ammd.fm2plus.AA10_7800;
import javaexams.templates.abstract_factory.ammd.fm2plus.ASU56734;

public class AmmdComputerFactory implements ComputerFactory {

    @Override
    public Processor createProcessor() {
        return new AA10_7800();
    }

    @Override
    public Motherboard createMotherboard() {
        return new ASU56734();
    }
}

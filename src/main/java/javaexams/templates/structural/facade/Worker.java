package javaexams.templates.structural.facade;

public class Worker implements WorkerFacade {

    @Override
    public void work() {
        ComplexInterface complexInterface = new ComplexClass();
        complexInterface.insertInSocket();
        complexInterface.turnOn();
        complexInterface.waitForOS();
        complexInterface.startProgram();
        complexInterface.writeResults();
        complexInterface.writeResults();
        complexInterface.turnOff();
        complexInterface.popFromSocket();
    }
}

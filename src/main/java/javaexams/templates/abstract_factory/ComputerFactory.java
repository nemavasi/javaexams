package javaexams.templates.abstract_factory;

public interface ComputerFactory {
    Processor createProcessor();
    Motherboard createMotherboard();
}

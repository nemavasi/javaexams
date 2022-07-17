package javaexams.templates.creational.abstract_factory;

public interface ComputerFactory {
    Processor createProcessor();
    Motherboard createMotherboard();
}

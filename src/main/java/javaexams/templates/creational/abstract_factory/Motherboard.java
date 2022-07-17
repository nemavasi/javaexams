package javaexams.templates.creational.abstract_factory;

public interface Motherboard {
    default void printName(){
        System.out.println(this.getClass().getName());
    }
}

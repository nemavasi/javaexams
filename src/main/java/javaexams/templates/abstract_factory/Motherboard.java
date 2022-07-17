package javaexams.templates.abstract_factory;

public interface Motherboard {
    default void printName(){
        System.out.println(this.getClass().getName());
    }
}

package javaexams.templates.abstract_factory;

public interface Processor {
    default void printName(){
        System.out.println(this.getClass().getName());
    }
}

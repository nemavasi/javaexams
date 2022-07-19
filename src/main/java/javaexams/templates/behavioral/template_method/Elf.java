package javaexams.templates.behavioral.template_method;

public class Elf extends AbstractGameUnit {

    @Override
    protected void changeStatus() {
        System.out.println("I am in attack for my king!");
    }

    @Override
    protected void saySomething() {
        System.out.println("For my king!");
    }

    @Override
    protected void throwSomethingIfCan() {
        System.out.println("throw arrow");
    }

    @Override
    protected void kickIfCan() {
        System.out.println("I am afraid of close attacks");
    }
}

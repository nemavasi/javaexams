package javaexams.templates.behavioral.template_method;

public class Orc extends AbstractGameUnit {

    @Override
    protected void changeStatus() {
        System.out.println("I am in attack");
    }

    @Override
    protected void saySomething() {
        System.out.println("Orc is attacking");
    }

    @Override
    protected void throwSomethingIfCan() {
        System.out.println("throw axe");
    }

    @Override
    protected void kickIfCan() {
        System.out.println("I am afraid of close attacks");
    }
}

package javaexams.templates.behavioral.template_method;

public abstract class AbstractGameUnit implements GameUnit {

    @Override
    public final void attack() {
        changeStatus();
        saySomething();
        throwSomethingIfCan();
        magicAttackIfCan();
        kickIfCan();
    }

    protected abstract void changeStatus();

    protected abstract void saySomething();

    protected abstract void throwSomethingIfCan();

    protected void magicAttackIfCan() {
        System.out.println("I don't have any magic");
    }

    protected abstract void kickIfCan();

}

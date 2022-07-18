package javaexams.templates.behavioral.state;

public class DraftState implements IState{

    @Override
    public void print() {
        System.out.println("draft printing is not allowed!");
    }
}

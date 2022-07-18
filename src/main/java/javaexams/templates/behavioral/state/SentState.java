package javaexams.templates.behavioral.state;

public class SentState implements IState{

    @Override
    public void print() {
        System.out.println("printing sent message!");
    }
}

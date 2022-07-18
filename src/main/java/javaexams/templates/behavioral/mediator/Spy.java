package javaexams.templates.behavioral.mediator;

public interface Spy {

    void sendMessage(String text);

    void receiveMessage(String text);

    SpiesMediator getMediator();
}

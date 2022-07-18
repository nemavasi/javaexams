package javaexams.templates.behavioral.mediator;

public abstract class AbstractSpy implements Spy {

    private SpiesMediator mediator;

    public AbstractSpy(SpiesMediator mediator) {

        this.mediator = mediator;
    }

    public void sendMessage(String text) {
        mediator.consumeMessage(text);
    };

    @Override
    public void receiveMessage(String text) {
        System.out.println(getClass().getName() + " received a message: " + text);
    }

    public SpiesMediator getMediator() {
        return mediator;
    }
}

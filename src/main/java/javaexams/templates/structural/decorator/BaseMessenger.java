package javaexams.templates.structural.decorator;

public abstract class BaseMessenger implements Messenger {

    private Messenger origin;

    protected BaseMessenger(Messenger messenger) {
        this.origin = messenger;
    }

    public void message() {
        if (origin != null) {
            origin.message();
        }
        extra();
    }

    protected abstract void extra();
}

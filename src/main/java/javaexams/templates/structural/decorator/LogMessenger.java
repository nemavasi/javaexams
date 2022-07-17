package javaexams.templates.structural.decorator;

public class LogMessenger extends BaseMessenger{

    protected LogMessenger(Messenger messenger) {
        super(messenger);
    }

    @Override
    protected void extra() {
        System.out.println("Logging...");
    }
}

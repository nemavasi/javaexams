package javaexams.templates.structural.decorator;

public class SMSMessenger extends BaseMessenger{

    protected SMSMessenger(Messenger messenger) {
        super(messenger);
    }

    @Override
    protected void extra() {
        System.out.println("SMS");
    }
}

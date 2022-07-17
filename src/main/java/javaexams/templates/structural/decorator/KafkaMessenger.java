package javaexams.templates.structural.decorator;

public class KafkaMessenger extends BaseMessenger{

    protected KafkaMessenger(Messenger messenger) {
        super(messenger);
    }

    @Override
    protected void extra() {
        System.out.println("sending to kafka...");
    }
}

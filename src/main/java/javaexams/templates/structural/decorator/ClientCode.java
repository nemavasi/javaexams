package javaexams.templates.structural.decorator;

public class ClientCode {

    public static void main(String[] args) {
        Messenger messenger1 = new SMSMessenger(new LogMessenger(null));
        Messenger messenger2 = new KafkaMessenger(new SMSMessenger(new LogMessenger(null)));

        messenger1.message();
        System.out.println();
        messenger2.message();
    }
}

//    Logging...
//    SMS
//
//    Logging...
//    SMS
//    sending to kafka...
package javaexams.templates.behavioral.chain_of_responsibility;

public class HandlerKafka extends BaseHandler {

    @Override
    public void handle(ClientRequest clientRequest) {
        if (clientRequest.getData().startsWith("kafka")) {
            System.out.println("send to kafka");
        } else {
            super.handle(clientRequest);
        }
    }
}

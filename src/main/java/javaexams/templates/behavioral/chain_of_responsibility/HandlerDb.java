package javaexams.templates.behavioral.chain_of_responsibility;

public class HandlerDb extends BaseHandler{

    @Override
    public void handle(ClientRequest clientRequest) {
        if (clientRequest.getData().startsWith("db")) {
            System.out.println("send to db");
        } else {
            super.handle(clientRequest);
        }
    }
}

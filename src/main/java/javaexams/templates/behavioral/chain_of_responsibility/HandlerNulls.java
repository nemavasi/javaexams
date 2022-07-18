package javaexams.templates.behavioral.chain_of_responsibility;

public class HandlerNulls extends BaseHandler {

    @Override
    public void handle(ClientRequest clientRequest) {
        if (clientRequest != null && clientRequest.getData() !=null) {
            super.handle(clientRequest);
        } else {
            System.out.println("write to log about null");
        }
    }
}

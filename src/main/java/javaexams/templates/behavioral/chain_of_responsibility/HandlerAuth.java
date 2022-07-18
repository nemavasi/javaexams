package javaexams.templates.behavioral.chain_of_responsibility;

public class HandlerAuth extends BaseHandler {

    @Override
    public void handle(ClientRequest clientRequest) {
        if ("main".equals(Thread.currentThread().getName())) {
            throw new RuntimeException("wrong thread");
        }
        super.handle(clientRequest);
    }
}

package javaexams.templates.behavioral.chain_of_responsibility;

public abstract class BaseHandler implements Handler {

    private Handler next;

    public final void setNext(Handler next) {
        this.next = next;
    }

    public void handle(ClientRequest clientRequest) {
        if (next != null) {
            next.handle(clientRequest);
        } else {
            System.out.println("end process");
        }
    }

}

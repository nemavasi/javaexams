package javaexams.templates.behavioral.chain_of_responsibility;

public interface Handler {
    void handle(ClientRequest clientRequest);
    void setNext(Handler next);
}

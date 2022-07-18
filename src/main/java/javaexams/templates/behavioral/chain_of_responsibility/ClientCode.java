package javaexams.templates.behavioral.chain_of_responsibility;

public class ClientCode {

    public static void main(String[] args) {

        Handler handlerDB = new HandlerDb();
        Handler handlerKafka = new HandlerKafka();
        handlerKafka.setNext(handlerDB);
        Handler handlerAuth = new HandlerAuth();
        handlerAuth.setNext(handlerKafka);
        Handler handler = new HandlerNulls();
        handler.setNext(handlerAuth);

        new Thread(() -> handler.handle(new CRequest("kafka-Hello"))).start();
        new Thread(() -> handler.handle(new CRequest("db-Hello"))).start();
        new Thread(() -> handler.handle(new CRequest(null))).start();
        handler.handle(new CRequest("kafka-Hello"));

    }
}
//    send to kafka
//    send to db
//    write to log about null
//    Exception in thread "main" java.lang.RuntimeException: wrong thread
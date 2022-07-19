package javaexams.templates.behavioral.visitor;

import java.util.Date;

public class ClientCode {

    public static void main(String[] args) {
        Note note = new Note(new Date(), "42");

        Order order = new Order(new Date(), "rrr-567-2022");

        DocumentVisitor visitorXMLPrinter = new DocumentVisitorXMLPrinter();
        DocumentVisitor visitorJsonPrinter = new DocumentVisitorJsonPrinter();

        note.accept(visitorXMLPrinter);
        order.accept(visitorXMLPrinter);

        System.out.println();

        note.accept(visitorJsonPrinter);
        order.accept(visitorJsonPrinter);

    }
}
//    xml 42
//    xml rrr-567-2022 19-07-2022
//
//    json 42
//    json rrr-567-2022 19-07-2022
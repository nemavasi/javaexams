package javaexams.templates.behavioral.visitor;

import java.util.Date;

public class ClientCode {

    public static void main(String[] args) {
        Note note = new Note(new Date(), "42");
        Order order = new Order(new Date(), "rrr-567-2022");
        Letter letter = new Letter(new Date(), "2022-15");
        Invoice invoice = new Invoice(new Date(), "2022-15-05/34");

        DocumentVisitor visitorXMLPrinter = new DocumentVisitorXMLPrinter();
        DocumentVisitor visitorJsonPrinter = new DocumentVisitorJsonPrinter();

        note.accept(visitorXMLPrinter);
        order.accept(visitorXMLPrinter);
        letter.accept(visitorXMLPrinter);
        invoice.accept(visitorXMLPrinter);

        System.out.println();

        note.accept(visitorJsonPrinter);
        order.accept(visitorJsonPrinter);
        letter.accept(visitorJsonPrinter);
        invoice.accept(visitorJsonPrinter);

    }
}

//    xml 42
//    xml rrr-567-2022 19-07-2022
//    xml Tue Jul 19 11:47:08 MSK 2022
//    xml 2022-15-05/34
//
//    json 42
//    json rrr-567-2022 19-07-2022
//    json 2022-15Tue Jul 19 11:47:08 MSK 2022
//    json 2022-15-05/34
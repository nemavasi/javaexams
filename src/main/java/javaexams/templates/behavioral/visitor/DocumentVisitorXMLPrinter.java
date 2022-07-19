package javaexams.templates.behavioral.visitor;

import java.text.SimpleDateFormat;

public class DocumentVisitorXMLPrinter implements DocumentVisitor {

    @Override
    public Object visit(Note note) {
        System.out.println("xml " + note.getNumber());
        return null;
    }

    @Override
    public Object visit(Order order) {
        System.out.println(
            "xml " + order.getNumber() + " " + new SimpleDateFormat("dd-MM-yyyy").format(order.getDate()));
        return null;
    }
}

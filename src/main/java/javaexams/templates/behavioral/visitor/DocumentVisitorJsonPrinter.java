package javaexams.templates.behavioral.visitor;

import java.text.SimpleDateFormat;

public class DocumentVisitorJsonPrinter implements DocumentVisitor {

    @Override
    public Object visit(Note note) {
        System.out.println("json " + note.getNumber());
        return null;
    }

    @Override
    public Object visit(Order order) {
        System.out.println(
            "json " + order.getNumber() + " " + new SimpleDateFormat("dd-MM-yyyy").format(order.getDate()));
        return null;
    }
}

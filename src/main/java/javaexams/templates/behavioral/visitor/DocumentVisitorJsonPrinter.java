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

    @Override
    public Object visit(Letter letter) {
        System.out.println("json " + letter.getNumber() + letter.getDate());
        return null;
    }

    @Override
    public Object visit(Invoice order) {
        System.out.println("json " + order.getNumber());
        return null;
    }
}

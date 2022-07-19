package javaexams.templates.behavioral.visitor;

public interface DocumentVisitor {

    Object visit(Note note);

    Object visit(Order order);

    Object visit(Letter order);

    Object visit(Invoice order);
}

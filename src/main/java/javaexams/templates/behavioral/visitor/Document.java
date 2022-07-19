package javaexams.templates.behavioral.visitor;

import java.util.Date;

public interface Document {

    String getType();

    Date getDate();

    String getNumber();

    Object accept(DocumentVisitor visitor);
}

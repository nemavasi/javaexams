package javaexams.templates.behavioral.visitor;

import java.util.Date;

public class Invoice implements Document {

    private Date date;
    private String number;

    public Invoice(Date date, String number) {
        this.date = date;
        this.number = number;
    }

    @Override
    public String getType() {
        return "INVOICE";
    }

    @Override
    public Date getDate() {
        return date;
    }

    @Override
    public String getNumber() {
        return number;
    }

    @Override
    public Object accept(DocumentVisitor visitor) {
        return visitor.visit(this);
    }
}

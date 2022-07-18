package javaexams.templates.behavioral.command;

public class InsertCommand implements ICommand{

    @Override
    public void execute() {
        System.out.println("insert");
    }
}

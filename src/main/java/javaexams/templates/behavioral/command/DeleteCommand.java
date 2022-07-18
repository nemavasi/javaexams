package javaexams.templates.behavioral.command;

public class DeleteCommand implements ICommand{

    @Override
    public void execute() {
        System.out.println("delete");
    }
}

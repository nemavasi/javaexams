package javaexams.templates.behavioral.command;

public class UpdateCommand implements ICommand{

    @Override
    public void execute() {
        System.out.println("update");
    }
}

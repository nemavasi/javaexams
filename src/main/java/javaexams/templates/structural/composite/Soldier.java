package javaexams.templates.structural.composite;

public class Soldier extends Unit implements IUnit {

    private Soldier(String name) {
        super(name);
    }

    public Soldier(String name, String patronymic, String surname) {
        super(String.join(" ", name, patronymic, surname));
    }

    public Soldier(String name, String surname) {
        super(String.join(" ", name, surname));
    }
}

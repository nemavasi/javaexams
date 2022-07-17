package javaexams.templates.structural.composite;

public class ClientCode {

    public static void main(String[] args) {
        Soldier soldier1 = new Soldier("John", "Dzu", "Ivanov");
        Soldier soldier2 = new Soldier("Ken", "Smith");

        Squad squad = new Squad("squad 456");
        squad.addUnit(soldier1);
        squad.addUnit(soldier2);

        squad.attack();

        squad.removeUnit(soldier1);
        squad.attack();
    }
}

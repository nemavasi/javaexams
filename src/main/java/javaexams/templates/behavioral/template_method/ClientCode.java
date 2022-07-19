package javaexams.templates.behavioral.template_method;

public class ClientCode {

    public static void main(String[] args) {
        GameUnit unit = new Elf();
        unit.attack();

        System.out.println();

        unit = new Orc();
        unit.attack();
    }
}

//    I am in attack for my king!
//    For my king!
//    throw arrow
//    I don't have any magic
//    I am afraid of close attacks
//
//    I am in attack
//    Orc is attacking
//    throw axe
//    I don't have any magic
//    I am afraid of close attacks
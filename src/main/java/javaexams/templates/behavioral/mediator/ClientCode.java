package javaexams.templates.behavioral.mediator;

import javaexams.templates.behavioral.mediator.impl.*;

public class ClientCode {

    public static void main(String[] args) {

        SpiesMediator mediator = new MediatorInSafePlace();

        Bear bear = new Bear(mediator);
        Cat cat = new Cat(mediator);
        Dog dog = new Dog(mediator);
        Fox fox = new Fox(mediator);
        Rabbit rabbit = new Rabbit(mediator);
        Wolf wolf = new Wolf(mediator);

        mediator.setBear(bear);
        mediator.setCat(cat);
        mediator.setDog(dog);
        mediator.setWolf(wolf);
        mediator.setFox(fox);
        mediator.setRabbit(rabbit);

        rabbit.sendMessage("bom!");
        System.out.println();
        fox.sendMessage("Cool!");
        System.out.println();
        wolf.sendMessage("row");
    }
}

//    javaexams.templates.behavioral.mediator.impl.Bear received a message: bom!
//
//    javaexams.templates.behavioral.mediator.impl.Bear received a message: Cool!
//
//    javaexams.templates.behavioral.mediator.impl.Bear received a message: row
//    javaexams.templates.behavioral.mediator.impl.Wolf received a message: row
//    javaexams.templates.behavioral.mediator.impl.Fox received a message: row
//    javaexams.templates.behavioral.mediator.impl.Dog received a message: row
//    javaexams.templates.behavioral.mediator.impl.Cat received a message: row
//    javaexams.templates.behavioral.mediator.impl.Rabbit received a message: row
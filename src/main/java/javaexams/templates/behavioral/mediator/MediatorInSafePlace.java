package javaexams.templates.behavioral.mediator;

import javaexams.templates.behavioral.mediator.impl.Bear;
import javaexams.templates.behavioral.mediator.impl.Cat;
import javaexams.templates.behavioral.mediator.impl.Dog;
import javaexams.templates.behavioral.mediator.impl.Fox;
import javaexams.templates.behavioral.mediator.impl.Rabbit;
import javaexams.templates.behavioral.mediator.impl.Wolf;

public class MediatorInSafePlace implements SpiesMediator {

    private Bear bear;
    private Cat cat;
    private Dog dog;
    private Fox fox;
    private Wolf wolf;
    private Rabbit rabbit;

    @Override
    public void consumeMessage(String message) {
        if (message.startsWith("b")) {
            bear.receiveMessage(message);
        } else if (message.startsWith("w")) {
            bear.receiveMessage(message);
            wolf.receiveMessage(message);
        } else if (message.startsWith("f")) {
            bear.receiveMessage(message);
            fox.receiveMessage(message);
        } else if (message.startsWith("r")) {
            bear.receiveMessage(message);
            wolf.receiveMessage(message);
            fox.receiveMessage(message);
            dog.receiveMessage(message);
            cat.receiveMessage(message);
            rabbit.receiveMessage(message);
        } else {
            bear.receiveMessage(message);
        }
    }

    public Bear getBear() {
        return bear;
    }

    public void setBear(Bear bear) {
        this.bear = bear;
    }

    public Cat getCat() {
        return cat;
    }

    public void setCat(Cat cat) {
        this.cat = cat;
    }

    public Dog getDog() {
        return dog;
    }

    public void setDog(Dog dog) {
        this.dog = dog;
    }

    public Fox getFox() {
        return fox;
    }

    public void setFox(Fox fox) {
        this.fox = fox;
    }

    public Wolf getWolf() {
        return wolf;
    }

    public void setWolf(Wolf wolf) {
        this.wolf = wolf;
    }

    public Rabbit getRabbit() {
        return rabbit;
    }

    public void setRabbit(Rabbit rabbit) {
        this.rabbit = rabbit;
    }
}

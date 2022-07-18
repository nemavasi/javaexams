package javaexams.templates.behavioral.mediator;

import javaexams.templates.behavioral.mediator.impl.Bear;
import javaexams.templates.behavioral.mediator.impl.Cat;
import javaexams.templates.behavioral.mediator.impl.Dog;
import javaexams.templates.behavioral.mediator.impl.Fox;
import javaexams.templates.behavioral.mediator.impl.Rabbit;
import javaexams.templates.behavioral.mediator.impl.Wolf;

public interface SpiesMediator {

    void consumeMessage(String message);

    void setBear(Bear bear);

    void setCat(Cat cat);

    void setDog(Dog dog);

    void setFox(Fox fox);

    void setRabbit(Rabbit rabbit);

    void setWolf(Wolf wolf);
}

package javaexams.templates.builder;

public class ClientCode {

    public void process() {
        Pizza hotPizza = new StandardMenu().hotPizza();

        Pizza customPizza = new PizzaBuilder(new Ingredient("dough 1", 200))
            .addCheese(new Ingredient("sulgini", 100))
            .addTomatoes(new Ingredient("From farmer 1", 200))
            .build();
    }
}

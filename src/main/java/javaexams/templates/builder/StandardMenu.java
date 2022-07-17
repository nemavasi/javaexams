package javaexams.templates.builder;

public class StandardMenu { //director
    public Pizza hotPizza(){
        return new PizzaBuilder(new Ingredient("dough 1", 200))
            .addCheese(new Ingredient("sulgini", 100))
            .addTomatoes(new Ingredient("From farmer 1", 200))
            .build();
    }

    public Pizza sugarPizza(){
        return new PizzaBuilder(new Ingredient("dough 2", 200))
            .addCheese(new Ingredient("livaro", 100))
            .addBananas(new Ingredient("Lala", 50))
            .build();
    }
}

package javaexams.templates.creational.builder;

public class PizzaBuilder {

    private Pizza result;

    public PizzaBuilder(Ingredient base) {
        result = new Pizza(base);
    }


    public PizzaBuilder addCheese(Ingredient ingredient) {
        result.setCheese(ingredient);
        return this;
    }

    public PizzaBuilder addTomatoes(Ingredient ingredient) {
        result.setTomatoes(ingredient);
        return this;
    }

    public PizzaBuilder addCucumber(Ingredient ingredient) {
        result.setCucumber(ingredient);
        return this;
    }

    public PizzaBuilder addOnion(Ingredient ingredient) {
        result.setOnion(ingredient);
        return this;
    }

    public PizzaBuilder addSalt(Ingredient ingredient) {
        result.setSalt(ingredient);
        return this;
    }

    public PizzaBuilder addSugar(Ingredient ingredient) {
        result.setSugar(ingredient);
        return this;
    }

    public PizzaBuilder addChili(Ingredient ingredient) {
        result.setChili(ingredient);
        return this;
    }

    public PizzaBuilder addMeat(Ingredient ingredient) {
        result.setMeat(ingredient);
        return this;
    }

    public PizzaBuilder addFish(Ingredient ingredient) {
        result.setFish(ingredient);
        return this;
    }

    public PizzaBuilder addOlives(Ingredient ingredient) {
        result.setOlives(ingredient);
        return this;
    }

    public PizzaBuilder addBananas(Ingredient ingredient) {
        result.setBananas(ingredient);
        return this;
    }

    public PizzaBuilder addStrawberries(Ingredient ingredient) {
        result.setStrawberries(ingredient);
        return this;
    }

    public Pizza build(){
        return result;
    }
}

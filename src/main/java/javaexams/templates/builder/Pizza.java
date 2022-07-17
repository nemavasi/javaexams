package javaexams.templates.builder;

public class Pizza {

    private final Ingredient base;
    private Ingredient cheese;
    private Ingredient tomatoes;
    private Ingredient cucumber;
    private Ingredient onion;
    private Ingredient salt;
    private Ingredient sugar;
    private Ingredient chili;
    private Ingredient meat;
    private Ingredient fish;
    private Ingredient olives;
    private Ingredient bananas;
    private Ingredient strawberries;

    public Pizza(Ingredient base) {
        this.base = base;
    }

    public Ingredient getBase() {
        return base;
    }

    public Ingredient getCheese() {
        return cheese;
    }

    public void setCheese(Ingredient cheese) {
        this.cheese = cheese;
    }

    public Ingredient getTomatoes() {
        return tomatoes;
    }

    public void setTomatoes(Ingredient tomatoes) {
        this.tomatoes = tomatoes;
    }

    public Ingredient getCucumber() {
        return cucumber;
    }

    public void setCucumber(Ingredient cucumber) {
        this.cucumber = cucumber;
    }

    public Ingredient getOnion() {
        return onion;
    }

    public void setOnion(Ingredient onion) {
        this.onion = onion;
    }

    public Ingredient getSalt() {
        return salt;
    }

    public void setSalt(Ingredient salt) {
        this.salt = salt;
    }

    public Ingredient getSugar() {
        return sugar;
    }

    public void setSugar(Ingredient sugar) {
        this.sugar = sugar;
    }

    public Ingredient getChili() {
        return chili;
    }

    public void setChili(Ingredient chili) {
        this.chili = chili;
    }

    public Ingredient getMeat() {
        return meat;
    }

    public void setMeat(Ingredient meat) {
        this.meat = meat;
    }

    public Ingredient getFish() {
        return fish;
    }

    public void setFish(Ingredient fish) {
        this.fish = fish;
    }

    public Ingredient getOlives() {
        return olives;
    }

    public void setOlives(Ingredient olives) {
        this.olives = olives;
    }

    public Ingredient getBananas() {
        return bananas;
    }

    public void setBananas(Ingredient bananas) {
        this.bananas = bananas;
    }

    public Ingredient getStrawberries() {
        return strawberries;
    }

    public void setStrawberries(Ingredient strawberries) {
        this.strawberries = strawberries;
    }
}

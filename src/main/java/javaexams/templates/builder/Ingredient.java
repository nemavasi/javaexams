package javaexams.templates.builder;

import java.util.Objects;

public class Ingredient {

    private String mark;
    private Integer gram;

    public Ingredient(String mark, Integer gram) {
        this.mark = mark;
        this.gram = gram;
    }

    public String getMark() {
        return mark;
    }

    public void setMark(String mark) {
        this.mark = mark;
    }

    public Integer getGram() {
        return gram;
    }

    public void setGram(Integer gram) {
        this.gram = gram;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        Ingredient that = (Ingredient) o;
        return Objects.equals(mark, that.mark) && Objects.equals(gram, that.gram);
    }

    @Override
    public int hashCode() {
        return Objects.hash(mark, gram);
    }
}

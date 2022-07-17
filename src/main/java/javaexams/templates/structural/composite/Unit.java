package javaexams.templates.structural.composite;

import static java.util.Collections.emptyList;
import static java.util.Optional.ofNullable;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

public abstract class Unit implements IUnit {

    private String name;

    public Unit(String name) {
        this.name = name;
    }

    private List<IUnit> children;

    @Override
    public Collection<IUnit> children() {
        return children;
    }

    @Override
    public void addUnit(Unit unit) {
        if (this == unit) {
            throw new RuntimeException("cycle");
        }
        //todo check other cycles!
        if (children == null) {
            children = new ArrayList<>();
        }
        children.add(unit);
    }

    @Override
    public void removeUnit(Unit unit) {
        children.remove(unit);
    }

    @Override
    public void attack() {
        System.out.println(name + " start attack!");
        ofNullable(children)
            .orElse(emptyList())
            .forEach(IUnit::attack);
    }
}

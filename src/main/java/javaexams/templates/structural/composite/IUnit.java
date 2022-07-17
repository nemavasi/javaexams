package javaexams.templates.structural.composite;

import java.util.Collection;

public interface IUnit {
    Collection<IUnit> children();
    void addUnit(Unit unit);
    void removeUnit(Unit unit);
    void attack();
}

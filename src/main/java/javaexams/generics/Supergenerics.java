package javaexams.generics;

import java.util.ArrayList;
import java.util.List;

public class Supergenerics {

    public static void main(String[] args) {
        List<? super Integer> wildSuperIntList = new ArrayList<>();
        List<Number> wildNumbersList = new ArrayList<>();

        //wildNumbersList = wildIntList;  //NOT COMPILE!!!
        wildSuperIntList = wildNumbersList;  //COMPILE!!!

        wildSuperIntList.add(42);
        //wildSuperIntList.add(42.0); //NOT COMPILE!!!
        //wildSuperIntList.add(new Object()); //NOT COMPILE!!!

        wildNumbersList.add(42);
        wildNumbersList.add(42.0);
    }
}

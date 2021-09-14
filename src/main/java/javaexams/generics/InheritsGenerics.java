package javaexams.generics;

import java.util.ArrayList;
import java.util.List;

public class InheritsGenerics {

    public static void main(String[] args) {
        List<Object> objectList = new ArrayList<>();
        List<Number> numberList = new ArrayList<>();
        //objectList = numberList;  // NOT COMPILE!!! no parent, no child

        List<?> wildObjectsList = new ArrayList<>();
        List<? extends Number> wildNumbersList = new ArrayList<>();
        wildObjectsList = wildNumbersList;  //COMPILE!!!

    }
}

package javaexams.templates.behavioral.iterator;

import java.util.Iterator;
import java.util.TreeSet;

public class ClientCode {

    public static void main(String[] args) {
        TreeSet<String> treeSet = new TreeSet<>();
        treeSet.add("name");
        treeSet.add("surname");
        treeSet.add("patronymic");

        Iterator<String> iterator = treeSet.iterator();
        while (iterator.hasNext()) {
            System.out.println(iterator.next());
        }

        System.out.println();

        iterator = treeSet.descendingIterator();
        while (iterator.hasNext()) {
            System.out.println(iterator.next());
        }

    }
}

//    name
//    patronymic
//    surname
//
//    surname
//    patronymic
//    name
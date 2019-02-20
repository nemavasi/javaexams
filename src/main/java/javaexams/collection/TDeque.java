package javaexams.collection;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.LinkedList;

public class TDeque {
    public static void main(String[] args) {

        Deque<String> deque = new ArrayDeque<>(); //new LinkedList<>();
        // методы генерирующие исключения

        //Все также как в обычное очереди

        deque.add("One");
        System.out.println(deque);
        // [One]

        deque.add("Two");
        System.out.println(deque);
        // [One, Two]

        System.out.println(deque.element());
        // One
        System.out.println(deque);
        // [One, Two]

        System.out.println(deque.remove());
        // One
        System.out.println(deque);
        // [Two]

        System.out.println(deque.remove());
        // Two

        //System.out.println(deque.remove());  //java.util.NoSuchElementException

        // а теперь особенные методы
        deque.add("One");
        deque.add("Two");
        System.out.println(deque);
        // [One, Two]
        deque.addFirst("Three");
        System.out.println(deque);
        // [Three, One, Two]
        System.out.println(deque.removeLast());
        // Two
    }
}

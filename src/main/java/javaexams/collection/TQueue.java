package javaexams.collection;

import java.util.LinkedList;
import java.util.Queue;

public class TQueue {
    public static void main(String[] args) {
        Queue<String> queue = new LinkedList<>();

        // методы генерирующие исключения
        queue.add("One");
        System.out.println(queue);
        // [One]

        queue.add("Two");
        System.out.println(queue);
        // [One, Two]

        System.out.println(queue.element());
        // One
        System.out.println(queue);
        // [One, Two]

        System.out.println(queue.remove());
        // One
        System.out.println(queue);
        // [Two]

        System.out.println(queue.remove());
        // Two

        //System.out.println(queue.remove()); java.util.NoSuchElementException


        System.out.println("***************************************");

        Queue<String> queue2 = new LinkedList<>();

        // методы не генерирующие исключения
        queue2.offer("One");
        System.out.println(queue2);
        // [One]

        queue2.offer("Two");
        System.out.println(queue2);
        // [One, Two]

        System.out.println(queue2.peek());
        // One
        System.out.println(queue2);
        // [One, Two]

        System.out.println(queue2.poll());
        // One
        System.out.println(queue2);
        // [Two]

        System.out.println(queue2.poll());
        // Two
        System.out.println(queue2.poll());
        // null

        System.out.println(queue.add(null)); //не для всех реализаций коллекций
        // true
        System.out.println(queue.offer(null)); //не для всех реализаций коллекций
        // true

    }

}

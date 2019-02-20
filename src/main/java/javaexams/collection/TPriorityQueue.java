package javaexams.collection;

import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Queue;

public class TPriorityQueue {

    public static void main(String[] args) {

        Queue<String> queue = new PriorityQueue<>();

        // методы генерирующие исключения
        queue.add("One");
        System.out.println(queue);
        // [One]

        queue.offer("Two");
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

        Queue<String> queue2 = new PriorityQueue<>();

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

        //System.out.println(queue.add(null)); // java.lang.NullPointerException

        //System.out.println(queue.offer(null)); //java.lang.NullPointerException

        System.out.println("***************************************");

        Queue<String> queue3 = new PriorityQueue<>();
        queue3.add("One");
        queue3.add("Twoo");
        queue3.add("Abcdf");
        System.out.println(queue3);
        // [Abcdf, Twoo, One]

        Queue<String> queue4 = new PriorityQueue<>(Comparator.comparingInt(String::length));
        queue4.add("One");
        queue4.add("Twoo");
        queue4.add("Abcdf");
        System.out.println(queue4);
        // [One, Twoo, Abcdf]

    }
}

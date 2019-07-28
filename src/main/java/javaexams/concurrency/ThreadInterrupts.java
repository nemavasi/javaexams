package javaexams.concurrency;

import java.sql.SQLOutput;
import java.util.Scanner;

public class ThreadInterrupts {

    public static void main(String[] args) {
        //testWaitingThreadinterrupt();
        testWaitingInInputThreadinterrupt();
    }

    //java.lang.InterruptedException
    public static void testWaitingThreadinterrupt(){

        Object lock = new Object();

        Thread thread = new Thread(new Runnable() {
            @Override
            public void run() {
                System.out.println("start new thread");
                try {
                    synchronized (lock) {
                        System.out.println("lock");
                        lock.wait();
                    }
                } catch (Exception e) {
                    e.printStackTrace();
                }

            }
        });

        thread.start();

        try {
            Thread.sleep(2000);
            thread.interrupt();
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

    }

    //java.lang.InterruptedException
    public static void testWaitingInInputThreadinterrupt(){

        Thread thread = new Thread(new Runnable() {
            @Override
            public void run() {
                Scanner scanner = new Scanner(System.in);
                scanner.next();
            }
        });
        thread.setDaemon(true);
        thread.start();

        try {
            Thread.sleep(2000);
            thread.interrupt();
            Thread.sleep(2000);
            System.out.println(thread.isInterrupted());

        } catch (InterruptedException e) {
            e.printStackTrace();
        }

    }
}

package javaexams.concurrency;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;

class MyReentrantLock extends ReentrantLock {

    MyReentrantLock(){
        super(true);
    }

    @Override
    public Collection<Thread> getWaitingThreads(Condition condition) {
        return super.getWaitingThreads(condition);
    }
}

class OneThread implements Runnable{

    private static MyReentrantLock lock = new MyReentrantLock();
    private static Condition condition = lock.newCondition();

    @Override
    public void run() {
        try {
            lock.lock();
            System.out.println(Thread.currentThread().getName() + " got lock");
            if (Thread.currentThread().getName().equals("Thread-0")) {
                condition.await(3, TimeUnit.SECONDS);
            } else {
                condition.await(30, TimeUnit.SECONDS);
            }

            for (Thread thread : lock.getWaitingThreads(condition)){
                System.out.println(thread.getName() + " is waiting");
                thread.interrupt();
            }

        } catch (InterruptedException e) {
            System.out.println(Thread.currentThread().getName() + " is interrupted");
        } finally {
            lock.unlock();
            System.out.println(Thread.currentThread().getName() + " finished");
        }
    }
}

public class WaitingThreads {

    public static void main(String[] args) {
        List<Thread> threadList = new ArrayList<>();
        for(int i = 0; i < 5; i++) {
            threadList.add(new Thread(new OneThread()));
        }

        for (Thread  thread : threadList) {
            thread.start();
        }
    }
}

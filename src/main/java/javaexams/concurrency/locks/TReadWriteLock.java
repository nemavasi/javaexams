package javaexams.concurrency.locks;

import java.text.SimpleDateFormat;
import java.util.*;
import java.util.concurrent.Callable;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.ReadWriteLock;
import java.util.concurrent.locks.ReentrantReadWriteLock;

public class TReadWriteLock {

    private Map<String, String> map = new HashMap<>();
    private ReadWriteLock rwLock = new ReentrantReadWriteLock();

    public static void main(String[] args) {

        TReadWriteLock obj = new TReadWriteLock();

        Callable<String> writer = () -> {
            try {
                obj.rwLock.writeLock().lock();
                System.out.println(Thread.currentThread().getName() + " - writer locked");
                TimeUnit.SECONDS.sleep(2);
                obj.map.put("time", (new SimpleDateFormat("hh:mm:ss")).format(new Date()));
            } catch (InterruptedException e) {
                e.printStackTrace();
            } finally {
                obj.rwLock.writeLock().unlock();
                System.out.println(Thread.currentThread().getName() + " - writer unlocked");
            }

            try {
                TimeUnit.SECONDS.sleep(2);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

            try {
                obj.rwLock.writeLock().lock();
                System.out.println(Thread.currentThread().getName() + " - writer locked");
                TimeUnit.SECONDS.sleep(2);
                obj.map.put("time", (new SimpleDateFormat("hh:mm:ss")).format(new Date()));
                TimeUnit.SECONDS.sleep(2);
            } catch (InterruptedException e) {
                e.printStackTrace();
            } finally {
                obj.rwLock.writeLock().unlock();
                System.out.println(Thread.currentThread().getName() + " - writer unlocked");
            }
            return null;
        };

        Collection<Callable<String>> threads = new ArrayList<>();
        threads.add(writer);
        for (int i=0; i < 10; i++) {
            threads.add(()->
            {
                try {
                    TimeUnit.SECONDS.sleep(1);
                    obj.rwLock.readLock().lock();
                    System.out.println(Thread.currentThread().getName() + " - reader locked");
                    System.out.println(obj.map.get("time"));
                    TimeUnit.SECONDS.sleep(10);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                } finally {
                    obj.rwLock.readLock().unlock();
                    System.out.println(Thread.currentThread().getName() + " - reader unlocked");
                }
                return null;
            });
        }

        try {
            Executors.newWorkStealingPool().invokeAll(threads);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }


    }
}

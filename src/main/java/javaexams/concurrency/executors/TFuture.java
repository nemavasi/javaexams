package javaexams.concurrency.executors;

import javaexams.BaseCheck;

import java.util.concurrent.*;

public class TFuture extends BaseCheck {
    public static void main(String[] args) {
        new TFuture().go();
    }

    @Override
    public void go() {

        p(Thread.currentThread().getName());

        ExecutorService es = Executors.newCachedThreadPool();

        Callable<String> c = new Callable<String>() {
            @Override
            public String call() throws Exception {
                p(Thread.currentThread().getName());
                Thread.sleep(3000);
                return "ok";
            }
        };
        Future<String> f = es.submit(c);
        try {
            p(f.get());
        } catch (Exception e) {
            e.printStackTrace();
        }
        es.shutdown();

    }
}

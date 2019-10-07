package javaexams.concurrency.executors;

import java.util.concurrent.*;

public class TimeoutExceptionCase {
    public static void main(String[] args) {
        Callable<String> task = () -> {
            try {
                TimeUnit.SECONDS.sleep(4);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            return "Ok";
        };

        ExecutorService service = Executors.newSingleThreadExecutor();
        Future<String> future = service.submit(task);

        String result = null;

        try {
            result = future.get(2, TimeUnit.SECONDS);
        } catch (ExecutionException e) {
            System.out.println(e.getMessage());
        } catch (InterruptedException e) {
            e.printStackTrace();
            System.out.println("InterruptedException");
        } catch (TimeoutException e) {
            e.printStackTrace();
            System.out.println("TimeoutException");
        }

        System.out.println(result);
        service.shutdown();
    }
}
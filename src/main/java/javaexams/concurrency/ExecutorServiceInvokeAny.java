package javaexams.concurrency;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.concurrent.*;

public class ExecutorServiceInvokeAny {
    public static void main(String[] args) {

        List<Callable<Integer>>  list = new ArrayList<>();
        list.add(
                ()->{
                    try {
                        TimeUnit.SECONDS.sleep(4);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    return 1;
                }
        );
        list.add(
                ()->{
                    try {
                        TimeUnit.SECONDS.sleep(2);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    return 42;
                }
        );
        list.add(
                ()->{
                    try {
                        TimeUnit.SECONDS.sleep(8);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    return 3;
                }
        );

        ExecutorService service = Executors.newWorkStealingPool();
        try {
            Integer result = service.invokeAny(list);
            System.out.println(result);
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (ExecutionException e) {
            e.printStackTrace();
        }
    }
}

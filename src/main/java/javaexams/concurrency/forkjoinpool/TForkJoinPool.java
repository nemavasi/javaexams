package javaexams.concurrency.forkjoinpool;

import java.util.Date;
import java.util.List;
import java.util.UUID;
import java.util.concurrent.ForkJoinPool;
import java.util.concurrent.RecursiveTask;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

/**
 * Created by dshalygin on 2/11/19.
 */
public class TForkJoinPool {
    public static void main(String[] args) {

        //можно поменять -Djava.util.concurrent.ForkJoinPool.common.parallelism=5
        System.out.println(ForkJoinPool.getCommonPoolParallelism());

        Date date1 = new Date();

        Stream<String> stream = IntStream.range(0, 5999999).mapToObj(x-> UUID.randomUUID().toString());
        MyRecursiveTask recursiveTask = new MyRecursiveTask(stream.collect(Collectors.toList()));
        String res = ForkJoinPool.commonPool().invoke(recursiveTask);
        System.out.println(res.length());
        Date date2 = new Date();

        System.out.println(date2.getTime() - date1.getTime()); //16709

    }


}

class MyRecursiveTask extends RecursiveTask<String> {
    private List<String> arr;

    public MyRecursiveTask(List<String> arr) {
        super();
        this.arr = arr;
    }

    @Override
    protected String compute() {
        if (arr.size() == 0) {
            return null;
        }

        if (arr.size() == 1) {
            return arr.get(0);
        }

        if (arr.size() == 2) {
            return arr.get(0) + arr.get(1);
        }


        int mid = arr.size() / 2;

        MyRecursiveTask task1 = new MyRecursiveTask(arr.subList(0, mid));
        task1.fork();                                                        //Кладёт задачу в очередь, и возвращается
        MyRecursiveTask task2 = new MyRecursiveTask(arr.subList(mid, arr.size()));
        task2.fork();


        String str2 = task2.join(); //Блокируется, пока задача не закончится
        String str1 = task1.join();

        return str1 + str2;

    }


}
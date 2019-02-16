package javaexams.concurrency;

import java.util.Date;
import java.util.List;
import java.util.UUID;
import java.util.concurrent.ForkJoinPool;
import java.util.concurrent.RecursiveAction;
import java.util.concurrent.RecursiveTask;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

/**
 * Created by dshalygin on 2/11/19.
 */
public class TForkJoinPoolRecursiveAction {
    public static void main(String[] args) {
        Date date1 = new Date();

        Stream<String> stream = IntStream.range(0, 599999).mapToObj(x-> UUID.randomUUID().toString());
        MyRecursiveTask recursiveTask = new MyRecursiveTask(stream.collect(Collectors.toList()));
        String res = ForkJoinPool.commonPool().invoke(recursiveTask);
        System.out.println(res.length());
        Date date2 = new Date();

        System.out.println(date2.getTime() - date1.getTime()); //16709

    }


}

class MyRecursiveAction extends RecursiveAction {
    private List<String> arr;

    public MyRecursiveAction(List<String> arr) {
        super();
        this.arr = arr;
    }

    @Override
    protected void compute() {
        if (arr.size() == 0) {
            return ;
        }

        if (arr.size() == 1) {
            return;
        }

        if (arr.size() == 2) {
            return;
        }


        int mid = arr.size() / 2;

        MyRecursiveTask task1 = new MyRecursiveTask(arr.subList(0, mid));
        task1.fork();                                                        //Кладёт задачу в очередь, и возвращается
        MyRecursiveTask task2 = new MyRecursiveTask(arr.subList(mid, arr.size()));
        task2.fork();


        String str2 = task2.join(); //Блокируется, пока задача не закончится
        String str1 = task1.join();

        return ;

    }


}
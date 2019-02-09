package javaexams.streamapi;

import javaexams.BaseCheck;

import java.util.stream.IntStream;

public class TReduce extends BaseCheck {
    public static void main(String[] args) {
        new TReduce().go();
    }

    @Override
    public void go() {

        Double sum = IntStream.of(0, 6 ,7, 56, 4)
                .asDoubleStream()
                .reduce(100, (x , y) -> Math.max(x,y))
                //.getAsDouble()
                ;
        p(sum);
    }
}

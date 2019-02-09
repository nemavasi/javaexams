package javaexams.streamapi;

import javaexams.BaseCheck;

import java.util.stream.IntStream;

public class TSumm extends BaseCheck {
    public static void main(String[] args) {
        new TSumm().go();
    }

    @Override
    public void go() {

        Double sum = IntStream.of(0, 6 ,7).asDoubleStream()
                .average().getAsDouble()
                ;
        p(sum);
    }
}

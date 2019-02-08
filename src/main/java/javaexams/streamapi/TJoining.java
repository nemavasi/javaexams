package javaexams.streamapi;

import javaexams.BaseCheck;

import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class TJoining extends BaseCheck {
    public static void main(String[] args) {
        new TJoining().go();
    }

    @Override
    public void go() {

        String s = IntStream.range(0, 10)
                .mapToObj(x->String.valueOf(x))
                .collect(Collectors.joining())
                ;
        p(s);
    }
}

package javaexams.streamapi;

import javaexams.BaseCheck;

import java.util.Optional;
import java.util.OptionalDouble;
import java.util.Random;

public class TIntStream extends BaseCheck {
    public static void main(String[] args) {
        new TIntStream().go();
    }

    @Override
    public void go() {
        boolean b = new Random(0).ints().anyMatch((x)->x>1000 && x<100000); //true
        p(b);
        boolean b2 = new Random(0).ints().noneMatch((x)->x>1000 && x<100000); //false
        p(b2);
        boolean b3 = new Random(0).ints().allMatch((x)->x>1000 && x<100000); //false
        p(b3);
        Optional<Integer> n = new Random(0).ints().boxed().filter((x)->x>1000 && x<100000).findFirst();
        n.ifPresent(this::p);

        OptionalDouble a = new Random().doubles().limit(5).peek(this::p).average();
        a.ifPresent(this::p);
    }
}

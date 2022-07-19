package javaexams.streamapi;

import java.util.function.Supplier;

public class Supplyers {

    String string = null;

    public void test() {
        string = "old";
        Supplier<String> s1 = () -> string.toUpperCase();
        Supplier<String> s2 = string::toUpperCase;
        string = "new";
        System.out.println(s1.get());
        System.out.println(s2.get());
    }

    public static void main(String[] args) {
        new Supplyers().test();
    }
}

//    NEW
//    OLD
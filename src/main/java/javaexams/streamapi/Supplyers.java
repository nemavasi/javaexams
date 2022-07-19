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


/*
* Java Method Reference ::
* Syntax: <classname or instancename>::<methodname>
* The method in the functional interface and the passing method reference should match for the argument and returntype.
* Method reference can be done for both static and class methods.
* */
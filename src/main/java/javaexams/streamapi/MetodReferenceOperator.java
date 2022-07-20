package javaexams.streamapi;

import java.util.function.Supplier;

//There are four kinds of method references ::
//
//    Static methods
//    Instance methods of particular objects
//    Instance methods of an arbitrary object of a particular type
//    Constructor

public class MetodReferenceOperator {

    String string = null;

    public void test() {
        string = "old";
        Supplier<String> s1 = () -> string.toUpperCase(); //Lambda expression
        Supplier<String> s2 = new Supplier<String>() {
            @Override
            public String get() {
                return string.toUpperCase();
            }
        };

        Supplier<String> s3 = string::toUpperCase;  //Method Reference bounded! receiver <instancename>::<methodname>

        string = "new";
        System.out.println(s1.get());
        System.out.println(s2.get());
        System.out.println(s3.get());
    }

    public static void main(String[] args) {
        new MetodReferenceOperator().test();
    }
}

//NEW
//NEW
//OLD


/*
* Java Method Reference ::
* Syntax: <classname or instancename>::<methodname>
* The method in the functional interface and the passing method reference should match for the argument and returntype.
* Method reference can be done for both static and class methods.
* */

//    instance and ClassName are called the receiver. More specifically, instance is called bounded receiver
//    while ClassName is called unbounded receiver.//
//    We call instance bounded receiver since the receiver is bounded to the instance.//
//    ClassName is unbouned receiver since the receiver is bounded later.
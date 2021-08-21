package javaexams.anonym;

public class AbstrAnonym {

    public static void main(String[] args) {
        Foo foo = new Foo() {
            void test(){}
        };
        //foo.test(); it does not compile because it is Foo class, and Foo class does not have test() method
    }

}

abstract class Foo {

}
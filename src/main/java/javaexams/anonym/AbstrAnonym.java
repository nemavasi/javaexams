package javaexams.anonym;

public class AbstrAnonym {

    public static void main(String[] args) {
        Foo foo = new Foo() {
            void test(){
                System.out.println("test");
            }
        };
        //foo.test(); it does not compile because it is Foo class, and Foo class does not have test() method

        var foo2 = new Foo() {
            void test(){
                System.out.println("test");
            }
        };
        foo2.test(); //because foo2 is non-denotable type, it has test() method
    }
}

abstract class Foo {

}
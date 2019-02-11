package javaexams.over;

class A1 {}

interface I1 {}

class B1 extends A1 implements I1 {}

public class TOverloadTest {
    static public  void foo(A1 a) { System.out.print("A"); }
    static private void foo(B1 b) { System.out.print("B"); }
    static private void foo(I1 i) { System.out.print("I"); }

    public static void main(String[] args) {
        A1 a = new B1();
        TOverloadTest.foo(a);
        TOverloadTest.foo((I1) a);
        TOverloadTest.foo(null);
        //AIB
    }

}

package javaexams.core;

public class ConstrFault {

    public static void main(String[] args) {
        A a = new B();
        System.out.println(a.getI());
    }
}

abstract class A {

    private int i;

    abstract int calc();

    A() {
        i = calc();
    }

    public int getI() {
        return i;
    }
}

class B extends A {

    int y = 40;

    B() {
        super();
    }

    @Override
    int calc() {
        return y + 2;
    }
}

//2
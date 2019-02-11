package javaexams.over;


class Parent {
    public static /*final*/ void print() {  //bug in compile time whern final
        System.out.println("Hello from Parent");
    }
}

class Child extends Parent {
    public  static void print() {
        System.out.println("Hello from Child");
    }
}

public class TStaticHiding {
    public static void main(String args[]) {
        Parent.print();
        Child.print();
    }
}


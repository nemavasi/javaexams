package javaexams.inherits.privatemethods;

public class Son extends Parent{
    public void go() {
        System.out.println("son");
    }

    public static void main(String[] args) {
        new Son().go();
    }
}

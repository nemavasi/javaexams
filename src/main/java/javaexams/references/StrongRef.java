package javaexams.references;

public class StrongRef {

    public static void main(String[] args) {
        String i = new String("42");
        i = null;
        //here "42" can be removed by gc
    }
}

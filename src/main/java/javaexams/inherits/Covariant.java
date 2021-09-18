package javaexams.inherits;

public class Covariant {

    interface Supl{
        Object get();
    }

    interface NumbSupl extends Supl{
        @Override
        Number get();
    }

    interface IntSuppl extends NumbSupl{
        @Override
        Integer get();
    }


    public static void main(String[] args) {
        System.out.println(( (IntSuppl)() -> 42).get()); //42
    }
}

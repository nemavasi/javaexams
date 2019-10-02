package javaexams.exceptions;

public class UseOutOfMemoryError {

    void doit(){
        long[] d;
        try{
            d = new long[999999999];
        }catch (OutOfMemoryError e){
            System.out.println("OutOfMemoryError");
            d = new long[99999999];
        }
        System.out.println(d.length);
    }

    public static void main(String[] args) {
        new UseOutOfMemoryError().doit();
    }

}

package javaexams.exceptions;

public class TStackOverflowError {

    void doit(){
        try{
            doit();
        }catch (StackOverflowError e){
            System.out.println("StackOverflowError");
        }
    }

    public static void main(String[] args) {
        new TStackOverflowError().doit();
    }

}

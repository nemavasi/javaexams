package javaexams.exceptions;

public class CatchRuntimeException {
    public static void main(String[] args) {
        try {
            throw new RuntimeException("aasasd");
        } catch (RuntimeException re) {
            System.out.println("catched!");
        }
    }
}

package javaexams.trycatch;

import java.io.InvalidObjectException;

public class MultyCatch {
    public static void main(String[] args) {
        try {
            throw new InvalidObjectException("test");
        } catch (InvalidObjectException | IllegalArgumentException e){

        }
    }
}

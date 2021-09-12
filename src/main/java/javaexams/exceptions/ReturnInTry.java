package javaexams.exceptions;

public class ReturnInTry {

    public static void main(String[] args) {
        try {
            return;
        } finally {
            System.out.println("finally");
        }
    }
}

//finally
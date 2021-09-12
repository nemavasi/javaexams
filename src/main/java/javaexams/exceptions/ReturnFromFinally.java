package javaexams.exceptions;

public class ReturnFromFinally {

    public static void main(String[] args) {
        System.out.println(test());
    }

    static int test(){
        try {
            return 13;
        } finally {
            return 42;
        }
    }
}

//42
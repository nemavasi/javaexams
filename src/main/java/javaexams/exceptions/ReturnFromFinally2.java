package javaexams.exceptions;

public class ReturnFromFinally2 {

    public static void main(String[] args) {
        System.out.println(test());
    }

    static int test() {
        int x = 13;
        try {
            return x;
        } finally {
            x = 42;
        }
    }
}

// 13
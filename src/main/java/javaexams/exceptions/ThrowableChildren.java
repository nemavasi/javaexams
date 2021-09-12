package javaexams.exceptions;

public class ThrowableChildren {

    public static void main(String[] args) throws Throwable {
        try {
            ThrowableChildren.main(null);
        } catch (Throwable e) {
            throw new Throwable("error", new ArithmeticException());
        }
    }
}

//    Exception in thread "main" java.lang.Throwable: error
//    at javaexams.exceptions.ThrowableChildren.main(ThrowableChildren.java:9)
//    Caused by: java.lang.ArithmeticException
//    ... 1 more

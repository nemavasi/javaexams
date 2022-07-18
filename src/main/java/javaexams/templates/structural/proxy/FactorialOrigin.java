package javaexams.templates.structural.proxy;

public class FactorialOrigin implements Factorial{

    public long factorial(int n) {
        if (n < 0) {
            throw new RuntimeException("wrong arg");
        }
        if (n < 2) {
            return 1;
        }
        return n + factorial(n - 1);
    }
}

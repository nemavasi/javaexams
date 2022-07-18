package javaexams.templates.structural.proxy;

public class ClientCode {

    public static void main(String[] args) {

        Factorial factorial = new FactorialProxy();

        System.out.println(factorial.factorial(5));

        new Thread(() -> System.out.println(factorial.factorial(5))).start();
    }
}
//15
//Exception in thread "Thread-0" java.lang.RuntimeException: access denied
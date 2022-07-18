package javaexams.templates.structural.proxy;

public class FactorialProxy implements Factorial {

    private FactorialOrigin origin;

    public FactorialProxy() {
        this.origin = new FactorialOrigin();
    }

    @Override
    public long factorial(int n) {
        if ("main".equals(Thread.currentThread().getName())) {
            return origin.factorial(n);
        }
        throw new RuntimeException("access denied");
    }
}

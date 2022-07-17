package javaexams.templates.creational.singlton;

public class LazySingletone {

    private LazySingletone() {
        System.out.println("LazySingletone created");
    }

    public static LazySingletone getInstance() {
        return Holder.instance;
    }

    private static class Holder {
        private static final LazySingletone instance = new LazySingletone();
    }

    public static void sayHello() {
        System.out.println("Hello!");
    }
}

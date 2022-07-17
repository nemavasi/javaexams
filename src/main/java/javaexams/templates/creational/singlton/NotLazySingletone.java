package javaexams.templates.creational.singlton;

public class NotLazySingletone {

    private static NotLazySingletone instance = new NotLazySingletone();

    private NotLazySingletone() {
        System.out.println("NotLazySingletone created");
    }

    public static NotLazySingletone getInstance() {

        return instance;
    }

    public static void sayHello() {
        System.out.println("Hello!");
    }
}

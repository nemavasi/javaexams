package javaexams.templates.creational.singlton;

public class ClientCode {

    public static void main(String[] args) {
        NotLazySingletone.sayHello();
        LazySingletone.sayHello();
    }
}

//    NotLazySingletone created
//    Hello!
//    Hello!

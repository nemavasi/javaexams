package javaexams.generics;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

public class WildCards {


    public static void main(String[] args) {

//        new ArrayList<?>(); // не скомпилируется - нельзя юзать ? при new , generic  может быть ссылка но не сам объект
//        new ArrayList<? extends Fooo>(); // не скомпилируется - нельзя юзать ? при new
//        new ArrayList<? super Fooo>(); // не скомпилируется - нельзя юзать ? при new


        List<Booo> listA = new ArrayList<>();
//        listA.add(new Foo()); //compile error
        listA.add(new Booo());
        listA.add(new Booz());

        List<?> listB = listA;
//        listB.add(new Foo()); //compile error java: incompatible types: javaexams.generics.Foo cannot be converted to capture#1 of ?
//        listB.add(new Boo()); //compile error java: javaexams.generics.Boo cannot be converted to capture#1 of ?
//        listB.add(new Boz());  //compile error java: incompatible types: javaexams.generics.Boz cannot be converted to capture#1 of ?

        List<? extends Fooo> listC = new ArrayList<>();
        listC.add(null); //остальные значение нельзя добавить в generic коллекцию - нельзя определить настоящий тип коллекции
//        listC.add(new Object());
//        listC.add(new Fooo()); //compile error java: а вдруг коллекция Booz?
//        listC.add(new Booo()); //compile error java:  а вдруг коллекция Booz?
//        listC.add(new Booz());  //compile error java:  а вдруг коллекция другого наследника Booo?

        List<? super Fooo> listD = new ArrayList<>(); //а здесь коллекция или Fooo или Object - полэтому все нижестоящие значения подходят
        listD.add(new Fooo());
        listD.add(new Booo());
        listD.add(new Booz());
//        listD.add(new Object()); // а вдруе коллекция Fooo?

        System.out.println(listD.size());

        process1(listA);
//        process1(listB); // compiler error
        process1(listC);
//        process1(listD); // compiler error

//        process2(listA); // compiler error
//        process2(listB); // compiler error
//        process2(listC); // compiler error
        process2(listD); // compiler error

    }

    private static void process1(Collection<? extends Fooo> collection){}
    private static void process2(Collection<? super Fooo> collection){}
}



class Fooo {}
class Booo extends Fooo {}
class Booz extends Booo {}

package javaexams.access;

public class TPrivate {
    private  class Test2 {
        private static final String name = "Name";
    }

    public static void main(String[] args) {
        System.out.println(Test2.name);
        //System.out.println(Fd.name2); //wrong
    }

    //В соответствии со спецификацией языка Java:
    // "if the member or constructor is declared private, then access is permitted if and only if it occurs
    // within the body of the top level class (§7.6) that encloses the declaration of the member or constructor"
    // - доступ к приватным членам вложенного класса разрешен из тела класса верхнего уровня,
    // в котором объявлен этот вложенный класс.
}

class Fd{
    private static final String name2 = "Name2";
}
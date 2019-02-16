package javaexams.access;

public class TPrivate {
    private static String nm = "sdf";
    private static class Test2 {

        private static class Test3{
            private static final String name = "Three";
        }

        private static final String name = "Name";

        private static String getNM(){
            return nm;
        }
    }

    public static void main(String[] args) {
        System.out.println(Test2.name + Test2.getNM() + Test2.Test3.name);

        //System.out.println(Fd.name2); //wrong
        //NamesdfThreed
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
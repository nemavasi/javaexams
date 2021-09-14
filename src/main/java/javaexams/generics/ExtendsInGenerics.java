package javaexams.generics;

public class ExtendsInGenerics {

    static class A {}

    interface B {
        void b();
    }

    interface C {
        void c();
    }

    static class E<T extends A & B & C, U, V> {  //A - class, B and C -interfaces!

        T resolve(T v) {
            return v;
        }
    }

    static class F extends A implements B, C {

        @Override
        public void b() {}

        @Override
        public void c() {}

        @Override
        public String toString() {
            return "F";
        }
    }

    public static void main(String[] args) {

        E<F, String, String> x = new E<>();
        F y = new F();
        System.out.println(x.resolve(y));     //F
    }
}

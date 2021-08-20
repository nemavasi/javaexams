package javaexams.over;

public class DiffReturnValue {

    public static void main(String[] args) {
        class A {

            String calc(int x){
                return "String";
            };

//            Integer calc(int x){  //not compile
//                return 42;
//            };

            Integer calc(int x, int y){
                return 42;
            };
        }

        A a = new A();
        System.out.println(a.calc(2));
        System.out.println(a.calc(2, 3));
    }
}

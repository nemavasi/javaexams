package javaexams.over;

public class Overloading {

    public static void main(String[] args) {
        Overloading overloading = new Overloading();
        overloading.test(Integer.valueOf(1025));
        overloading.test((int)Integer.valueOf(1025));
    }

    public void test(int i){
        System.out.println("int " + i);
    }

    public void test(Object o){
        System.out.println("obj " + o);
    }

//    obj 1025
//    int 1025
}

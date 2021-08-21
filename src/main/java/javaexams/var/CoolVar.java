package javaexams.var;

public class CoolVar {

    public static void main(String[] args) {
        //Object o = new Object(){
        var o = new Object(){  //non-denotable type
            public double g = 9.8;
            public void test() {
                System.out.printf("g = %f", g);
            }
        };
        o.test(); //Object does not have "test" method
    }
}

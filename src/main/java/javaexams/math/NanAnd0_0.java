package javaexams.math;

public class NanAnd0_0 {

    public static void main(String[] args) {
        System.out.println(Double.NaN); //NaN

        System.out.println(Double.NaN==Double.NaN); //false

        System.out.println(-0.0==0.0);    //true
        System.out.println(Double.toString(-0.0)==Double.toString(0.0)); //false
        System.out.println(Double.toString(-0.0));   //-0.0
        System.out.println(1/-0.0);    //-Infinity
        System.out.println(1/0.0);    //Infinity
        System.out.println(-0.0==0);    //true
        System.out.println(Double.compare(0, -0.0)); //1
        System.out.println(Double.compare(0, 0.0));  //0

        System.out.println(Float.NaN==Float.NaN); //false
        System.out.println(Float.isNaN(Float.NaN)); //true

        System.out.println(Math.PI);                 //3.141592653589793
        System.out.println(Math.nextUp(Math.PI));    //3.1415926535897936
        System.out.println(Math.ulp(Math.PI));       //4.440892098500626E-16
    }
}

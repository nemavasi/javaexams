package javaexams.generics;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class GenArrays {

    public static void main(String[] args) {
        //1
        //List<Integer>[] arrayOfList = new List<Integer>[0]; //NOT COMPILE
        //List<? extends Number>[] arrayOfList = new ArrayList<Integer>[10]; // NOT COMPILE
        List<?>[] arrayOfList = new ArrayList<?>[10]; // COMPILE

        //arrayOfList[0] = Arrays.asList("doo"); //java.lang.ArrayStoreException
        //arrayOfList[0].add("sdef"); //NOT COMLILE



        //2
        List<String> listStr = Arrays.asList("foo", "boo");
        //String[] arrStr = (String[]) listStr.toArray(); //java.lang.ClassCastException: class [Ljava.lang.Object; cannot be cast to class [Ljava.lang.String;
        Object[] arrObj = listStr.toArray();
        System.out.println(Arrays.toString(arrObj)); //[foo, boo]

        String[] arrStr02 = new String[1];
        String[] arrStr2 = listStr.toArray(arrStr02);
        String[] arrStr03 = new String[2];
        String[] arrStr3 = listStr.toArray(arrStr03);
        System.out.println(Arrays.toString(arrStr2));  //[foo, boo]
        System.out.println(arrStr2==arrStr02);         //false
        System.out.println(arrStr3==arrStr03);         //true
    }
}

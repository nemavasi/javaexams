package javaexams.arrays;

import java.util.Arrays;

public class ArraysCopies {

    public static void main(String[] args) {
        int[][] m = new int[][] {{2, 3, 4}, {8, 9}, {0}};

        System.out.println(m.length);       //3
        System.out.println(m[0].length);    //3
        System.out.println(m[2].length);    //1

        var mShallowCopy = m.clone();
        var mStreamShallowCopy = Arrays.stream(m).toArray();
        var mStreamDeepCopy = Arrays.stream(m).map(int[]::clone).toArray();
        System.out.println(m == mShallowCopy);         //false
        System.out.println(m.equals(mShallowCopy));    //false!
        System.out.println(Arrays.equals(m, mShallowCopy));  //true
        System.out.println(Arrays.equals(m, mStreamShallowCopy));  //true
        System.out.println(Arrays.equals(m, mStreamDeepCopy));  //false
        System.out.println(Arrays.deepEquals(m, mStreamDeepCopy));  //true

        System.out.println(Arrays.toString(m));                  //[[I@7eda2dbb, [I@6576fe71, [I@76fb509a]
        System.out.println(Arrays.toString(mShallowCopy));       //[[I@7eda2dbb, [I@6576fe71, [I@76fb509a]
        System.out.println(Arrays.toString(mStreamShallowCopy)); //[[I@7eda2dbb, [I@6576fe71, [I@76fb509a]
        System.out.println(Arrays.toString(mStreamDeepCopy));    //[[I@1f17ae12, [I@4d405ef7, [I@6193b845]


        m[2][0] +=1;
    }

}

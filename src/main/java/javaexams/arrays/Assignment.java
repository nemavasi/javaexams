package javaexams.arrays;

import java.util.Arrays;

public class Assignment {

    private static int[] arr = new int[]{1, 2, 3, 4};
    private static Integer[] arrObj = new Integer[]{5, 6, 7, 8};

    public static void main(String[] args) {
        int[] a = arr;
        a[0] = 42; //по факту копируется адрес массива
        System.out.println(Arrays.toString(arr));

        //arrObj = arr; Несовместимые типы
    }
}

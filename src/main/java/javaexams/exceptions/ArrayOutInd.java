package javaexams.exceptions;

public class ArrayOutInd {
    public static void main(String[] args) {
        String[][] arr = new String[][]{{"sdfg", "dfgdfdd"}, null, {"ddddddd"}};
        try {
            System.out.println(arr[2][1]);
        } catch (ArrayIndexOutOfBoundsException e) {
            System.out.println(e.getClass()); //class java.lang.ArrayIndexOutOfBoundsException
        }
    }
}

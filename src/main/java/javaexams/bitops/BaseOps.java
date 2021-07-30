package javaexams.bitops;

public class BaseOps {

    public static void main(String[] args) {
        System.out.println(~0); //-1
        System.out.println(~-1); //0

        System.out.println(1<<7); //128

        System.out.println(-32>>1); //-16
        System.out.println(-32>>>1); //2147483632

        System.out.println(Integer.toBinaryString(-2)); //11111111111111111111111111111110
        System.out.println(-2>>2); //-1
        System.out.println(-2<<2); //-8
        System.out.println(Integer.toBinaryString(-8)); //11111111111111111111111111111000

        System.out.println(Integer.toBinaryString(7));    //  00111
        System.out.println(Integer.toBinaryString(18));   //  10010
        System.out.println(Integer.toBinaryString(7^18)); //  10101
        System.out.println(Integer.toBinaryString(7|18));  // 10111
        System.out.println(Integer.toBinaryString(7&18));  // 00010

        System.out.println(Integer.toBinaryString(-1)); //11111111111111111111111111111111
        System.out.println(-1>>>1); //2147483647
        System.out.println(Integer.toBinaryString(2147483647)); //01111111111111111111111111111111

        System.out.println(-1>>1); //-1
        System.out.println(-1>>2); //-1
        System.out.println(-1>>3); //-1
        System.out.println(-1<<1); //-2    или 11111111111111111111111111111110

        System.out.println(Integer.toBinaryString(Integer.rotateLeft(1, 1)));   //     10
        System.out.println(Integer.toBinaryString(Integer.rotateRight(1, 1))); //10000000000000000000000000000000
        System.out.println(Integer.rotateRight(1, 1)); //-2147483648
        System.out.println(Integer.bitCount(7)); //3
        System.out.println(Integer.bitCount(-1)); //32
        System.out.println(Integer.highestOneBit(7)); //4
        System.out.println(Integer.highestOneBit(15)); //8

        System.out.println(Integer.reverse(1)); //-2147483648
        System.out.println(Integer.toBinaryString(-2147483648)); //10000000000000000000000000000000
    }
}

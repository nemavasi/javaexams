package javaexams.math;

public class LinkOrValue {

    public static void main(String[] args) {
        Integer i = 1000;
        addInt(i);
        System.out.println(i);
    }

    private static void addInt(Integer i){
        int count = 0;
        while (++count < 10)
            i++;
        System.out.println(i);
    }
}

//1009
//1000


//That's the artifact of autoboxing and a fact that Integer is immutable in Java.
//
//    The a++ and a-- are translated to roughly this.
//
//    int intA = a.getInt( );
//    intA++;
//    a = Integer.valueOf( intA ); // this is a reference different from b
package javaexams.interfaces;

public interface ITestDefaultMethods {

    default int length(int x, int y) {
        return x + y;
    }

//    default boolean equals(Object o){ //default method overrides method from Object class
//        return this == o;
//    }
}

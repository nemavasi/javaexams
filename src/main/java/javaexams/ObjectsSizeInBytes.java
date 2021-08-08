package javaexams;

import org.openjdk.jol.vm.VM;   //look at jol dependency in POM!

public class ObjectsSizeInBytes {

    public static void main(String[] args) {
        System.out.println(VM.current().details());  //...Field sizes by type: 4, 1, 1, 2, 2, 4, 4, 8, 8 [bytes]

//        So here are the space requirements for each simple data type in the JVM:
//
//        Object references consume 4 bytes
//        boolean and byte values consume 1 byte
//        short and char values consume 2 bytes
//        int and float values consume 4 bytes
//        long and double values consume 8 bytes
    }
}

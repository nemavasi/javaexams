package javaexams.references;

import java.lang.ref.SoftReference;

public class SoftRef {
  //Soft References: In Soft reference, even if the object is free for garbage collection then also its not garbage collected,
  // until JVM is in need of memory badly.The objects gets cleared from the memory when JVM runs out of memory.
  // To create such references java.lang.ref.SoftReference class is used.

    public static void main(String[] args) {

        Tst g = new Tst(); //strong
        g.go();

        SoftReference<Tst> softRef = new SoftReference<Tst>(g);

        g = null; //strong ref removed

        System.gc(); // force gc

        softRef.get().go(); //if gc removed object NPE could be

    }

}

//    zooooo
//    zooooo
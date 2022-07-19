package javaexams.references;

import java.lang.ref.WeakReference;

public class WeakRef {

    //This type of reference is used in WeakHashMap to reference the entry objects .
    //If JVM detects an object with only weak references (i.e. no strong or soft references linked to any object object), this object will be marked for garbage collection.
    //To create such references java.lang.ref.WeakReference class is used.

    public static void main(String[] args) {

        Tst g = new Tst(); //strong
        g.go();

        WeakReference<Tst> weakRef = new WeakReference<>(g);

        g = null; //strong ref removed

        //System.gc(); // force gc -> NPE

        weakRef.get().go(); //if gc removed object NPE could be

    }

    //Two different levels of weakness can be enlisted: Soft and Phantom
}

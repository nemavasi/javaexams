package javaexams.references;

import java.lang.ref.PhantomReference;
import java.lang.ref.ReferenceQueue;

public class PhantomRef {

    //The objects which are being referenced by phantom references are eligible for garbage collection.
    // But, before removing them from the memory, JVM puts them in a queue called ‘reference queue’ .
    // They are put in a reference queue after calling finalize() method on them.
    // To create such references java.lang.ref.PhantomReference class is used

//    We can't get a referent of a phantom reference.
//    The referent is never accessible directly through the API and this is why we need a reference queue to work with this type of references.
//
//    The Garbage Collector adds a phantom reference to a reference queue after the finalize method of its referent is executed.
//    It implies that the instance is still in the memory.

//    The first technique is to determine when an object was removed from the memory which helps to schedule
//    memory-sensitive tasks. For example, we can wait for a large object to be removed before loading another one.
//
//    The second practice is to avoid using the finalize method and improve the finalization process.

    public static void main(String[] args)
    {
        //Strong Reference
        Tst g = new Tst();
        g.go();

        //Creating reference queue
        ReferenceQueue<Tst> refQueue = new ReferenceQueue<>();

        //Creating Phantom Reference to Gfg-type object to which 'g'
        //is also pointing.
        PhantomReference<Tst> phantomRef = null;

        phantomRef = new PhantomReference<>(g, refQueue);

        //Now, Tst-type object to which 'g' was pointing
        //earlier is available for garbage collection.
        //But, this object is kept in 'refQueue' before
        //removing it from the memory.
        g = null; //available for garbage collection. But, this object is kept in 'refQueue' before removing from the memory.

        //It always returns null.
        g = phantomRef.get();

        //It shows NullPointerException.
        g.go();
    }
}


//zooooo
//Exception in thread "main" java.lang.NullPointerException
//	at javaexams.references.PhantomRef.main(PhantomRef.java:37)
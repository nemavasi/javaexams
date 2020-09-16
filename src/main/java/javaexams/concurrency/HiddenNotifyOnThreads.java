package javaexams.concurrency;

public class HiddenNotifyOnThreads {
  // объяснение кто вызывает notify на thread видимо такое - https://stackoverflow.com/questions/9866193/who-and-when-notify-the-thread-wait-when-thread-join-is-called
  /**
   * /jdk7/hotspot/src/share/vm/runtime/thread.cpp
   *
   * void JavaThread::run() {
   *   ...
   *   thread_main_inner();
   * }
   *
   * void JavaThread::thread_main_inner() {
   *   ...
   *   this->exit(false);
   *   delete this;
   * }
   *
   * void JavaThread::exit(bool destroy_vm, ExitType exit_type) {
   *   ...
   *   // Notify waiters on thread object. This has to be done after exit() is called
   *   // on the thread (if the thread is the last thread in a daemon ThreadGroup the
   *   // group should have the destroyed bit set before waiters are notified).
   *   ensure_join(this);
   *   ...
   * }
   *
   * static void ensure_join(JavaThread* thread) {
   *   // We do not need to grap the Threads_lock, since we are operating on ourself.
   *   Handle threadObj(thread, thread->threadObj());
   *   assert(threadObj.not_null(), "java thread object must exist");
   *   ObjectLocker lock(threadObj, thread);
   *   // Ignore pending exception (ThreadDeath), since we are exiting anyway
   *   thread->clear_pending_exception();
   *   // Thread is exiting. So set thread_status field in  java.lang.Thread class to TERMINATED.
   *   java_lang_Thread::set_thread_status(threadObj(), java_lang_Thread::TERMINATED);
   *   // Clear the native thread instance - this makes isAlive return false and allows the join()
   *   // to complete once we've done the notify_all below
   *   java_lang_Thread::set_thread(threadObj(), NULL);
   *   lock.notify_all(thread);
   *   // Ignore pending exception (ThreadDeath), since we are exiting anyway
   *   thread->clear_pending_exception();
   * }
   * */


  //а также https://docs.oracle.com/en/java/javase/14/docs/api/java.base/java/lang/Thread.html#join(long)
  /**
   *  As a thread terminates the this.notifyAll method is invoked. It is recommended that applications not use wait, notify, or notifyAll on Thread instances.
   */

  /**
   * Блин - wait еще и кроме этого через spurious wakeups может разбулиться - поэтому юзай wait в цикле с проверкой переменной
   * */

  public static void main(String[] args) throws InterruptedException {

    Thread thread = new Thread(() -> {
      try {
        Thread.sleep(2000);
      } catch (Exception e) {
      }
      System.out.println("Thread End");
    });

    synchronized (thread) {
      thread.start();
      thread.wait();
    }
    System.out.println("Main End");
  }


//    public static void main(String[] args) throws InterruptedException {
//        Thread thread = new Thread(()-> new Runnable(){ //это совсем не то - просто будет создан Runnable и выкинут
//            @Override
//            public void run() {
//                System.out.println("Thread End");
//            }
//        } );
//        synchronized (thread) {
//            thread.start();
//            thread.wait();
//        }
//        System.out.println("Main End");
//    }

//    public static void main(String[] args) {
//        System.out.println("hello");
//        http://www.ya.ru
//        System.out.println("world");
//    }
}

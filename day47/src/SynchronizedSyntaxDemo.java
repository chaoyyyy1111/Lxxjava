public class SynchronizedSyntaxDemo {
    public synchronized void func() {

    }
    public static synchronized void func1() {

    }
    public void otherMethod() {
        Object o = new Object();
        synchronized (o) {

        }
        synchronized (this) {

        }
        synchronized (SynchronizedSyntaxDemo.class) {

        }
    }
}

import java.sql.Time;

public class ThreadUnsafeDemo {
     public static final int N = 1000000;
     public static int v = 0;
     static class Add implements Runnable {
         @Override
         public void run() {
             synchronized (ThreadUnsafeDemo.class) {
                 for (int i = 0; i < N ; i++) {
                     v++;
                 }
             }

         }
     }
    static class Sub implements Runnable {
        @Override
        public void run() {
            synchronized (ThreadUnsafeDemo.class) {
                for (int i = 0; i < N ; i++) {
                    v--;
                }
            }
        }
    }

    public static void main(String[] args) throws InterruptedException {
         Add add = new Add();
         Sub sub = new Sub();
         Thread thread1 = new Thread(add);
         Thread thread2 = new Thread(sub);
         long b = System.currentTimeMillis();
         thread1.start();
         thread2.start();
         thread1.join();
         thread2.join();
        long e = System.currentTimeMillis();
        System.out.println(v);
        System.out.println((e-b)/1000.0);
    }
}

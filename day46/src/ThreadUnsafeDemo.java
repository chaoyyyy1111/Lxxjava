public class ThreadUnsafeDemo {
     public static final int N = 1000000;
     public static int v = 0;
     static class Add implements Runnable {
         @Override
         public void run() {
             for (int i = 0; i < N ; i++) {

                 v++;
             }
         }
     }
    static class Sub implements Runnable {
        @Override
        public void run() {
            for (int i = 0; i < N ; i++) {
                v--;
            }
        }
    }

    public static void main(String[] args) throws InterruptedException {
         Add add = new Add();
         Sub sub = new Sub();
         Thread thread1 = new Thread(add);
         Thread thread2 = new Thread(sub);
         thread1.start();
         thread2.start();
         thread1.join();
         thread2.join();
        System.out.println(v);
    }
}

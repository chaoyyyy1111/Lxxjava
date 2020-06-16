
public class ThreadSpeedUp {
    public static final long N = 10000_0000L;
    public static final int C = 10;
    static class Calc extends Thread {
        long r = 0;
        @Override
        public void run() {
            for (int i = 0; i < N; i++) {
                r += i;
            }
            System.out.println(r);
        }
    }
    public static void func() throws InterruptedException {
        Calc[] threads = new Calc[C-1];
        for (int i = 0; i < C-1 ; i++) {
            threads[i] = new Calc();
            threads[i].start();
        }
        long r = 0;
        for (int i = 0; i < N; i++) {
            r += i;
        }
        System.out.println(r);
        for (int i = 0; i < C-1; i++) {
           threads[i].join();
        }
    }
    public static void main(String[] args) {

    }
}

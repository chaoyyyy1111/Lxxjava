import java.util.Scanner;

public class WaitNotifyDemo {
    private static final Object o = new Object();
    static class SubThread extends Thread {
        @Override
        public void run() {
            try{
                System.out.println("等待之前");
                synchronized (o) {
                    o.wait();
                }
                System.out.println("等待结束");
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

        }
    }
    public static void main(String[] args) {
         SubThread s = new SubThread();
         s.start();
         Scanner scan = new Scanner(System.in);
         scan.nextLine();
         synchronized (o) {
             o.notify();
         }
    }
}

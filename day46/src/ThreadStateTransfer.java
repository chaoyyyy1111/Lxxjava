import java.util.Scanner;
import java.util.concurrent.TimeUnit;

public class ThreadStateTransfer {
    static class SubThread extends Thread {
        @Override
        public void run() {
                Scanner scan = new Scanner(System.in);
                scan.nextLine();
                System.out.println("子线程即将退出");
        }
    }
    public static void main(String[] args) throws InterruptedException {
        SubThread s = new SubThread();
        System.out.println(s.getState());
        s.start();
        System.out.println(s.getState());
        while(s.isAlive()) {
            System.out.println(s.getState());
            TimeUnit.SECONDS.sleep(1);
        }
        System.out.println(s.getState());

    }
}

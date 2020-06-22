
import java.util.Scanner;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;

public class JavaBlockingQueue {
private static BlockingQueue<Integer> bq = new ArrayBlockingQueue<>(16);
    static class Producer extends Thread {
        @Override
        public void run() {
            try {
                for (int i = 0; true ; i++) {
                    bq.put(i);
                    System.out.println("生产了一个"+i);
                }
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
    public static void main(String[] args) {
        try {
            for (int i = 0; i < 5 ; i++) {
                Producer p = new Producer();
                p.start();
            }
            Scanner scan = new Scanner(System.in);
            while(true) {
                scan.nextLine();
                System.out.println("消费了一个"+bq.take());
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}

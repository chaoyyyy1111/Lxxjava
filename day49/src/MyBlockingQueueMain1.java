import java.util.Scanner;

public class MyBlockingQueueMain1 {
    private static final MyBlockingQueue mq = new MyBlockingQueue();
    static class Consumer extends Thread {
        @Override
        public void run() {
            try {
                while(true) {
                    System.out.println("消费了"+mq.pop());
                }
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
    public static void main(String[] args) {
        Consumer consumer = new Consumer();
        consumer.start();
        Scanner scan = new Scanner(System.in);
        try {
            int i = 0;
            while(true) {
                scan.nextLine();
                System.out.println("生产了"+i);
                mq.push(i++);
            }
        } catch(InterruptedException e) {
            e.printStackTrace();
        }
    }
}

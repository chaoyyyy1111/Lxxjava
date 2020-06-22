import java.util.Scanner;

public class MyBlockingQueueMain {
private static final MyBlockingQueue mq = new MyBlockingQueue();

static class Producer extends Thread {
    @Override

        public void run() {
        try {
            for (int i = 0; true ; i++) {
                mq.push(i);
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
            System.out.println("消费了一个"+mq.pop());
        }
    } catch (InterruptedException e) {
        e.printStackTrace();
    }
}
}

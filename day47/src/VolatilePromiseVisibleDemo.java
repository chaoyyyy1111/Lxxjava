public class VolatilePromiseVisibleDemo {
public static volatile boolean run = true;
static class Runner extends Thread {
    @Override
    public void run() {
        while(run) {

        }
        System.out.println("run退出了");
    }
}

    public static void main(String[] args) throws InterruptedException {
        Runner runner = new Runner();
        runner.start();
        Thread.sleep(2);
        System.out.println("2秒结束");
        run = false;


    }
}

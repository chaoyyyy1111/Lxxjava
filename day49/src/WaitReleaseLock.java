public class WaitReleaseLock {
static Object o1 = new Object();
static Object o2 = new Object();
static class SubThread extends Thread {
    @Override
    public void run() {
        try {
            synchronized(o1) {
                synchronized (o2) {
                    o2.wait();
                }
            }
        } catch(InterruptedException e) {
            e.printStackTrace();
        }

    }
}

    public static void main(String[] args) throws InterruptedException {
         SubThread subThread = new SubThread();
         subThread.start();
         Thread.sleep(1000);
         synchronized (o2) {
             o2.notify();
             System.out.println("叫醒了");
         }
         synchronized (o1) {
             System.out.println("抢到o1锁");
         }

    }
}

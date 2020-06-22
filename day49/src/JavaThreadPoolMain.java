import java.util.concurrent.*;

public class JavaThreadPoolMain {
    static class MyFactory implements ThreadFactory {
        @Override
        public Thread newThread(Runnable r) {
            return new Thread(r,"hahaha");
        }
    }

    public static void main(String[] args) throws InterruptedException {
        BlockingQueue<Runnable> queue = new ArrayBlockingQueue<>(3);
        ExecutorService threadPool = new ThreadPoolExecutor(
                10,
                10,
                0,
                TimeUnit.SECONDS,
                queue,
                new MyFactory(),
                new ThreadPoolExecutor.AbortPolicy()
        );
        for (int i = 0; true ; i++) {
            Runnable target = new Runnable() {
                @Override
                public void run() {
                    try {
                        TimeUnit.MINUTES.sleep(1);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }

                }
            };
            System.out.println("提交第"+i+"个任务");
            System.out.println(queue.size());
            threadPool.execute(target);
            TimeUnit.SECONDS.sleep(1);
        }
    }
 }

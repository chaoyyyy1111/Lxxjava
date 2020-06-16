public class JoinDemo {
     static class C extends Thread {
         @Override
         public void run() {
             long r = 0;
             for (long i = 0; i < 1000000000L ; i++) {
                 r += i;
             }
             System.out.println(r);
         }
     }

    public static void main(String[] args) throws InterruptedException {
        C c = new C();
        c.start();
        System.out.println("我要等c");
        c.join();
        System.out.println("c走完了");
    }
}

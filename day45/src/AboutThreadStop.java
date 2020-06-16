import java.util.Scanner;

public class AboutThreadStop {
    private static volatile boolean isInterrupted = false;
    static class B extends Thread{
         public B () {
             super("B");
         }

         @Override
         public void run() {
             try {
                 while(true) {
                     System.out.println("我在挖煤");

                     Thread.sleep(5000);

                     System.out.println("是否有人让我停止" + isInterrupted);
                     if(isInterrupted) {
                         System.out.println("停了");
                         break;
                     }
                 }
             } catch(InterruptedException e) {
                 System.out.println("睡觉呢");
             }
         }
     }
    public static void main(String[] args) {
        B b = new B();
        b.start();
        Scanner scan = new Scanner(System.in);
        String str = scan.nextLine();
        System.out.println("准备通知停止");
        isInterrupted = true;
        System.out.println("已经通知停止");
    }
}

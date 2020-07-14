import java.util.Scanner;
import java.util.concurrent.TimeUnit;

public class AboutThreadStop2 {
      static class A extends Thread{
          public A() {

              super("A");
          }

          @Override
          public void run() {
              Thread t = Thread.currentThread();

                  while(true) {
                      System.out.println("挖煤");
                      //TimeUnit.SECONDS.sleep(2);
                      boolean interrupted = Thread.interrupted();
                      System.out.println("是否有人叫我停" + interrupted);
                      if(interrupted) {
                          System.out.println("运行时停止");
                          break;
                      }

                  }


          }
      }

    public static void main(String[] args) {
        A a = new A();
        a.start();
        Scanner scan = new Scanner(System.in);
        String str = scan.nextLine();
        System.out.println("准别通知停止");
        a.interrupt();
        System.out.println("已经叫停");
    }
}

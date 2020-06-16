public class HowToInstanceThread  {
     private static class A extends Thread{
         @Override
         public void run() {
             for (int i = 0; i < 100 ; i++) {
                 System.out.println("A");
             }
         }
     }
     private static class B extends Thread {
         @Override
         public void run() {
             for (int i = 0; i < 100 ; i++) {
                 System.out.println("B");
             }
         }
     }

    public static void main(String[] args) {
        A a = new A();
        B b = new B();
        a.start();
        b.start();
        for (int i = 0; i < 100; i++) {
            System.out.println("Main");
        }
    }
}

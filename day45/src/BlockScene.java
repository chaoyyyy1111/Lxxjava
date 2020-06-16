import java.util.Scanner;

public class BlockScene {

    static class Fib extends Thread {
        private int n;
        public Fib(int n) {
            this.n = n;
        }
        public static int func(int n) {
             if(n < 2) {
                 return n;
             }
             return func(n-1) + func(n-2);
        }
        @Override
        public void run() {
            System.out.println(func(n));
        }
    }
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        while(true) {
            int n = scan.nextInt();
            Fib fib = new Fib(n);
            fib.start();
        }

    }


}

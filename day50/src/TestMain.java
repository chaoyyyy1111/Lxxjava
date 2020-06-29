
import java.util.Scanner;

public class TestMain {
    public static int func1(int a,int c) {
        int f1 = a;
        int f2 = c;
        while(f1 % f2 != 0) {
            int tmp = f1 % f2;
            f1 = f2;
            f2 = tmp;
        }
        return f2;
    }
    public static int func(int a,int[] b) {
        for (int i = 0; i < b.length ; i++) {
            if(a >= b[i]) {
                a += b[i];
            } else {
                a += func1(a,b[i]);
            }
        }
        return a;
    }
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        while(scan.hasNext()) {
            int n = scan.nextInt();
            int a = scan.nextInt();
            int[] b = new int[n];
            for (int i = 0; i < n ; i++) {
                b[i] = scan.nextInt();
            }
            System.out.println(func(a,b));
        }
    }
}

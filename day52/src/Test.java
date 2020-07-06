import java.util.*;

public class Test {
    public static int func(int n) {
        int count = 0;
        int tmp = n;
        while(tmp != 0) {
            if(tmp % 2 == 1) {
                count++;
            }
            tmp /= 2;
        }
        if(count % 2 == 0) {
            n = n|128;
        }
        return n;
    }
    public static void main(String[] args) {
         Scanner scan = new Scanner(System.in);
         while(scan.hasNext()) {
             String str = scan.next();
             for (int i = 0; i < str.length() ; i++) {
                 char c = str.charAt(i);
                 int n = func(c);
                 for (int j = 7; j >= 0 ; j--) {
                     System.out.print((n >> j) & 1);
                 }
                 System.out.println();
             }
         }


    }
}
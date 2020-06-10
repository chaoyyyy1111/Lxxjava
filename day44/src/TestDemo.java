import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class TestDemo {
    public static int func(int n) {
        int ret = 1;
        while(n > 0) {
            ret *= n;
            n--;
        }
        return ret;
    }
    public static void main1(String[] args) {

        Scanner scan = new Scanner(System.in);
        while(scan.hasNext()) {
            int n = scan.nextInt();
            int ret = func(n);

            System.out.println(ret);
        }


    }
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int n = scan.nextInt();
        List<Character> list = new ArrayList<>();
        if(n == 0) {
            list.add((char)(48));
        }
        while(n > 0) {
            list.add((char)(n % 10 + 48));
            n /= 10;
        }
        char[] cs = new char[list.size()];
        int i = 0;
        for (char c :list) {
            cs[i++] = c;
        }
        String str = new String(cs);
        System.out.println(str);
    }
}



import java.util.Arrays;
import java.util.Scanner;

public class TestDemo {
    public static void func(String a,String[] str) {
        if(str.length == 0) {
            System.out.print(a);
        } else {
            System.out.print(a);
            System.out.println(Arrays.toString(str));
            System.out.print(Arrays.toString(str));
            System.out.println(a);
            String tmp = str[str.length-1];
            func(tmp,Arrays.copyOfRange(str,0,str.length-1));
        }
    }
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int n = Integer.parseInt(scan.nextLine());
        String strs = scan.nextLine();
        String str[] = strs.split(" ");
        String a = str[str.length-1];
        str = Arrays.copyOfRange(str,0,str.length-1);
        func(a,str);
    }
}

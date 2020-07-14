import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.Stack;

public class TestDemo {
    public static String[] func(String[] str,int k,int m) {
        while(k > 0) {
            Stack<String> stack = new Stack<>();
            Stack<String> stack1 = new Stack<>();
            Stack<String> stack2 = new Stack<>();
            for (int i = 0; i < m ; i++) {
                stack1.push(str[i]);
                stack2.push(str[i+m]);
            }
            for (int i = 0; i < m ; i++) {
                stack.push(stack2.pop());
                stack.push(stack1.pop());
            }
            for (int i = 0; i < str.length ; i++) {
                str[i] = stack.pop();
            }
            k--;
        }
        return str;
    }
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        String n = scan.nextLine();
        int count = Integer.parseInt(n);
        List<String[]> list = new ArrayList<>();
        for (int i = 0; i < count ; i++) {
            int m = Integer.parseInt(scan.nextLine());
            int k = Integer.parseInt(scan.nextLine());
            String[] strs2 = new String[2*m];
            for (int j = 0; j < 2*m ; j++) {
                strs2[j] = scan.nextLine();
            }
            String[] str = func(strs2,k,m);
            list.add(str);
        }
        for (String[] strs:list) {
            for (int i = 0; i < strs.length-1 ; i++) {
                System.out.print(strs[i]+" ");
            }
            System.out.println(strs[strs.length-1]);
        }
    }
}

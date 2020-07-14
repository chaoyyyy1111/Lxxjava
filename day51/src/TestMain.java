import java.util.*;

public class TestMain {
    public static long func(long n,long i) {
        long count = (3-i)*8;
        long ret = 0;
        while(n > 0) {
            if(n % 2 == 1) {
                ret += (long)Math.pow(2,count);
            }
            n = n/2;
            count++;
        }
        return ret;
    }
    public static Stack<Long> func1(long num) {
        Stack<Long> stack = new Stack<>();
        long count = 0;
        long ret = 0;
        long i = 0;
        while(i < 4) {
            while(count < 8) {
                if(num % 2 == 1) {
                    ret += (long)Math.pow(2,count);
                }
                num = num/2;
                count++;
            }
            stack.push(ret);
            ret = 0;
            count = 0;
            i++;
        }
        return stack;
    }
    public static void main(String[] args) {
        System.out.println(2 << 0);
        //Scanner scan = new Scanner(System.in);


        //String str = scan.nextLine();
        //long num = scan.nextLong();
        //String[] strs = str.split("\\.");
        long sum = 0L;
        //for (long i = 0; i < strs.length ; i++) {
            //sum += func(Long.parseLong(strs[i]),i);
        //}
        //System.out.println(sum);
        //Stack<Long> stack = func1(num);
        //long qSize = stack.size();
        //for (long i = 0; i < qSize-1 ; i++) {
            //System.out.print(stack.pop()+".");
        //}
        //System.out.println(stack.pop());




    }
}
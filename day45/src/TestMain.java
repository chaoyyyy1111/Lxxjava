
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;
import java.util.Stack;

class Node {
     int val;
     Node next;
     public Node(int val) {
         this.val = val;
     }
}
public class TestMain {
    public static void func(Node head,String str) {
        int i = str.length() - 2;
        Node cur = head;
        while(i >= 0) {
            cur.next = new Node(str.charAt(i--)-48);
            cur = cur.next;
        }
    }
    public static void main1(String[] args) {
        Scanner scan = new Scanner(System.in);
        String str1 = scan.nextLine();
        String str2 = scan.nextLine();
        Node head1 = new Node(str1.charAt(str1.length() - 1)-48);
        Node head2 = new Node(str2.charAt(str2.length() - 1)-48);
        func(head1,str1);
        func(head2,str2);
        Node cur1 = head1;
        Node cur2 = head2;
        Node newHead = new Node(-1);
        Node cur = newHead;
        int tmp = 0;
        while(cur1 != null || cur2 != null) {
            int num1 = cur1 != null ? cur1.val : 0;
            int num2 = cur2 != null ? cur2.val : 0;
            int sum = (num1 + num2 + tmp)%10;
            cur.next = new Node(sum);
            tmp = (num1 + num2 + tmp)/10;
            if(cur1 != null) {
                cur1 = cur1.next;
            }
            if(cur2 != null) {
                cur2 = cur2.next;
            }
            cur = cur.next;
        }
        if(tmp != 0) {
            cur.next = new Node(tmp);
        }
        Stack<Integer> stack = new Stack<>();
        Node cur0 = newHead.next;
        while(cur0 != null) {
            stack.push(cur0.val);
            cur0 = cur0.next;
        }
        int i = 0;
        char[] ret = new char[stack.size()];
        while(!stack.empty()) {
            ret[i++] = (char)(stack.pop()+48);
        }
        System.out.println(new String(ret));
    }

    public static void main2(String[] args) {
        Scanner scan = new Scanner(System.in);
        String input = scan.nextLine();
        String[] strs = input.split(" ");
        int[] nums = new int[strs.length];
        for (int i = 0; i < nums.length ; i++) {
            nums[i] = Integer.parseInt(strs[i]);
        }
        Map<Integer,Integer> map = new HashMap<>();
        for(int i = 0;i <= 9;i++) {
            map.put(i,nums[i]);
        }
        StringBuffer sb = new StringBuffer();
        if(!map.containsKey(0)) {
            for (int i = 1; i <= 9 ; i++) {
                for (int j = 0; j < map.get(i) ; j++) {
                    sb.append(i);
                }
            }
        } else {
            for (int i = 1; i <= 9 ; i++) {
                if(map.containsKey(i)) {
                    sb.append(i);
                    map.put(i,map.get(i)-1);
                    break;
                }
            }
            for (int i = 0; i <= 9 ; i++) {
                for (int j = 0; j < map.get(i) ; j++) {
                    sb.append(i);
                }
            }
        }
        System.out.println(sb.toString());
    }

    public static int mul(int n) {
        int sum = 0;
        int i = 0;
        while(i < n) {
            sum += i;
            i++;
        }
        return sum+1;
    }
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        while(scan.hasNextInt()) {
            int n = scan.nextInt();
            StringBuffer sb = new StringBuffer();
            for (int i = mul(n) * 2 - 1; i < mul(n) * 2 - 1+(n-1)*2 ; i+=2) {
                sb.append(i+"+");
            }
            sb.append(mul(n) * 2 - 1+(n-1)*2);
            System.out.println(sb);
        }

    }
}

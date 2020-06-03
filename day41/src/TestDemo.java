import sun.text.normalizer.UCharacter;

import java.util.*;

public class TestDemo {
    public static boolean chkParenthesis(String A, int n) {
        // write code here
        for(int i = 0;i < A.length();i++) {
            if(A.charAt(i) != '(' && A.charAt(i) != ')') {
                return false;
            }
        }
        Stack<Character> stack = new Stack<>();
        for(int i = 0;i < A.length();i++) {
            if(A.charAt(i) == '(') {
                stack.push(A.charAt(i));
            } else {
                if(stack.empty()) {
                    return false;
                } else {
                    stack.pop();
                }
            }
        }
        if(!stack.empty()) {
            return false;
        }
        return true;
    }
    public static void main(String[] args) {
        /*Scanner scan = new Scanner(System.in);
        String str = scan.nextLine();
        Queue<Character> queue = new LinkedList<>();
        PriorityQueue<String> pq = new PriorityQueue<>(new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {
                return o2.length() - o1.length();
            }
        });
        for (int i = 0; i < str.length() ; i++) {
            if(str.charAt(i) >='0' && str.charAt(i) <='9') {
                queue.offer(str.charAt(i));
            } else if((str.charAt(i) <'0' || str.charAt(i) >'9')
            && !queue.isEmpty()) {
                StringBuffer sb = new StringBuffer();
                while(!queue.isEmpty()) {
                    sb.append(queue.poll());
                }
                pq.add(sb.toString());
            }
        }
        if(!queue.isEmpty()) {
            StringBuffer sb = new StringBuffer();
            while(!queue.isEmpty()) {
                sb.append(queue.poll());
            }
            pq.add(sb.toString());
        }
        System.out.println(pq.peek());
         */
        System.out.println(chkParenthesis("()(()()", 7));

    }



}

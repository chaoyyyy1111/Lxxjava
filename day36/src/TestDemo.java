import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public class TestDemo {
    public boolean isValid(String s) {
        Stack<Character> stack = new Stack<>();
        for (int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);
            if(ch == '(' || ch == '[' || ch == '{') {
                stack.push(ch);
            } else {
                if(stack.empty()) {
                    System.out.println("右括号多了");
                    return false;
                }
                char ch1 = stack.peek();
                if(ch1 == '(' && ch == ')' || ch1 == '[' && ch == ']'
                        || ch1 == '{' && ch == '}') {
                    stack.pop();
                } else {
                    System.out.println("左右括号不匹配");
                    return false;
                }
            }
        }
        if(!stack.empty()) {
            System.out.println("左括号多了");
            return false;
        }
        return true;
    }
    public static void main(String[] args) {
       /* Stack<Integer> stack = new Stack<>();
        stack.push(1);
        stack.push(2);
        stack.push(3);
        stack.push(4);
        stack.push(5);
        System.out.println(stack.search(1));
        System.out.println(stack.peek());
        System.out.println(stack.pop());
        System.out.println(stack.peek());
        System.out.println("========================");
        Queue<Integer> queue = new LinkedList<>();
        queue.offer(1);
        queue.offer(2);
        queue.offer(3);
        queue.offer(4);
        System.out.println(queue.peek());
        System.out.println(queue.poll());
        System.out.println(queue.peek());
        */
       char a ='1';
       int num = Integer.valueOf(a);
        System.out.println(num);
        Stack<Integer> stack = new Stack<>();
    }
}

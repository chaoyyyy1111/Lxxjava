import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public class TestDemo {
    public static void main(String[] args) {
        String str = "1";
        int a = Integer.parseInt(str);
        System.out.println(a);
        StringBuffer sb1 = new StringBuffer();
        Stack<Character> sta1 = new Stack<>();
        Queue<Integer> queue = new LinkedList<>();
        queue.offer(1);
        queue.offer(2);
        queue.offer(3);
        System.out.println(queue);
        queue.remove(2);
        System.out.println(queue);
        ArrayList<Integer> array = new ArrayList<>();
        array.add(1);

    }
}

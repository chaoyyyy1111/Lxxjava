import java.util.LinkedList;
import java.util.Queue;

public class MyStack {
    private Queue<Integer> queue1;
    private Queue<Integer> queue2;
    /** Initialize your data structure here. */
    public MyStack() {
        queue1 = new LinkedList<>();
        queue2 = new LinkedList<>();
    }
    public void push(int x) {
        if(queue1.isEmpty() && queue2.isEmpty()) {
            queue1.offer(x);
        }else if(!queue1.isEmpty()) {
            queue1.offer(x);
        } else {
            queue2.offer(x);
        }
    }
    public int pop() {
        if(empty()) {
            return -1;
        }
        int qusize1 = queue1.size();
        int qusize2 = queue2.size();
        if(!queue1.isEmpty()) {
            for (int i = 0; i <qusize1-1; i++) {
                queue2.offer(queue1.poll());
            }
            return queue1.poll();
        } else {
            for (int i = 0; i < qusize2-1; i++) {
                queue1.offer(queue2.poll());
            }
            return queue2.poll();
        }
    }
    public int top() {
        if(empty()) {
            return -1;
        }
        int qusize1 = queue1.size();
        int qusize2 = queue2.size();
        int data = 0;
        if(!queue1.isEmpty()) {
            for (int i = 0; i <qusize1; i++) {
                data = queue1.poll();
                queue2.offer(queue1.poll());
            }
            return data;
        } else {
            for (int i = 0; i < qusize2; i++) {
                data = queue2.poll();
                queue1.offer(queue2.poll());
            }
            return data;
        }
    }
    public boolean empty() {
        if(queue1.isEmpty() && queue2.isEmpty()) {
            return true;
        }
        return false;
    }
}

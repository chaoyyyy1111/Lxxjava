import java.util.Stack;

public class MyQueue {
    private Stack<Integer> stack1;
    private Stack<Integer> stack2;
    public MyQueue() {
        this.stack1 = new Stack<>();
        this.stack2 = new Stack<>();
    }
    public void offer() {

    }
    public int pop() {
        if (empty()) {
            return -1;
        }
        if (stack2.empty()) {
            int stsize = stack1.size();
            for (int i = 0; i < stsize; i++) {
                stack2.push(stack1.pop());
            }

        }
        return stack2.pop();
    }
    public boolean empty() {
        if(stack1.empty() && stack2.empty()) {
            return true;
        }
        return false;
    }
}

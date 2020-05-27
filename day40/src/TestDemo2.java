class MyStack <T> {
    public T[] elem;
    public int top;
    public MyStack() {
        this.elem = (T[])new Object[10];
    }
    public void push(T val) {
        this.elem[this.top++] = val;
    }
    public T peek() {
        return this.elem[this.top-1];
    }
}
public class TestDemo2 {
    public static void main(String[] args) {
        MyStack<Integer> myStack = new MyStack<>();
    }
}

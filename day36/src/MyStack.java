import java.util.Arrays;

public class MyStack {
    public int[] elem;//数组
    public int top;//表示当前可以存放数据元素的下标

    public MyStack() {
        this.elem = new int[10];
    }

    public void push(int val) {
        if(full()){
            this.elem = Arrays.copyOf(this.elem,this.elem.length*2);
        }
        this.elem[top++] = val;
    }
    public boolean full() {
        return this.top == this.elem.length;
    }
    public boolean empty() {
        return this.top == 0;
    }
    public int peek() {
        if(empty()) {
            throw new RuntimeException("栈为空");
        }
        return this.elem[this.top-1];
    }
    public int poll() {
        if(empty()) {
            throw new RuntimeException("栈为空");
        }
        return this.elem[--this.top];
    }
    public int size() {
        return this.top;
    }
}

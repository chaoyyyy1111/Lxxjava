class ListNode {
    public int data;
    public ListNode next;
    public ListNode(int data) {
        this.data = data;
    }
}
public class MyQueue {
    public ListNode front;
    public ListNode rear;
    public int usedSize;
    public boolean offer(int val) {
        ListNode listNode = new ListNode(val);
        if(isEmpty()) {
            this.front = listNode;
            this.rear = listNode;
        }else{
            this.rear.next = listNode;
            this.rear = listNode;
        }
        this.usedSize++;
        return true;
    }
    public int poll() {
        if(isEmpty()) {
            throw new RuntimeException("队列为空");
        }
        int ret = this.front.data;
        this.front = this.front.next;
        this.usedSize--;
        return ret;
    }
    public int peek() {
        if(isEmpty()) {
            throw new RuntimeException("队列为空");
        }
        return this.front.data;
    }
    public boolean isEmpty() {
        return this.usedSize == 0;
    }
    public int size() {
        return this.usedSize;
    }
}

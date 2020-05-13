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
    public boolean offer(int val) {
        ListNode listNode = new ListNode(val);
        if(this.front == null) {
            this.front = listNode;
            this.rear = listNode;
        }else{
            this.rear.next = listNode;
            this.rear = listNode;
        }
        return true;
    }



}

public class MyBlockingQueue {
private volatile int size;
private int[] array = new int[1];
private int front = 0;
private int rear = 0;
public synchronized void push(int num) throws InterruptedException {
    while(size >= array.length) {
        wait();
    }
    array[rear] = num;
    rear = (rear+1) % array.length;
    size++;
    notifyAll();
}
public synchronized int pop() throws InterruptedException {
    while(size == 0) {
        wait();
    }
    int tmp = array[front];
    front = (front+1) % array.length;
    size--;
    notifyAll();
    return tmp;
}
public int getSize() {
    return size;
}
}

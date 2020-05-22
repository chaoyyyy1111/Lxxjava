import java.util.PriorityQueue;

public class TestMain {
    public static void main(String[] args) {
        int[] array = {1,2,3,4,5,6};
        TestHeap testHeap = new TestHeap();
        testHeap.createHeap(array);
        testHeap.show();
        testHeap.pop();
        testHeap.show();
        testHeap.push(10);
        testHeap.heapSort();
        testHeap.show();
        System.out.println("=========================");
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        pq.offer(4);
        pq.offer(2);
        pq.offer(1);
        pq.offer(3);
        System.out.println(pq.peek());
        pq.poll();
        System.out.println(pq.peek());

    }
}

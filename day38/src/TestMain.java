import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.Random;

public class TestMain {
    public static void main(String[] args) {
       /* int[] array = {1,2,3,4,5,6};
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
        */
       /*int[] array = new int[10000];
       Sort sort = new Sort();
        Random random = new Random();
        for (int i = 0; i < array.length ; i++) {
            array[i] = random.nextInt(10000);
        }
        long start = System.currentTimeMillis();
        int[] drr = {5,3,1};
        for(int i = 0 ; i < drr.length;i++) {
            sort.shellSort(array,drr[i]);
        }

        sort.bubbleSort(array);
        long end = System.currentTimeMillis();
        System.out.println(end - start);*/
        Sort sort = new Sort();
        int[] arr = {1,3,5,8,9};
        System.out.println(Arrays.toString(arr));
        sort.quickSort(arr);
        System.out.println(Arrays.toString(arr));

    }
}

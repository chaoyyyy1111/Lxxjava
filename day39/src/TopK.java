import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;

class MyComparator implements Comparator<Integer> {
    @Override
    public int compare(Integer o1, Integer o2) {
        return o2-o1;
    }
}
public class TopK {
    public static int[] topK(int[] array,int k) {
        //MyComparator myComparator = new MyComparator();
        PriorityQueue<Integer> pq = new PriorityQueue<>(new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                return o1-o2;
            }
        });
        for (int i = 0; i < array.length; i++) {
            if(pq.size() < k) {
                pq.offer(array[i]);
            } else {
                if(pq.peek() < array[i]) {
                    pq.poll();
                    pq.offer(array[i]);
                }
            }
        }
        int[] ret = new int[k];
        for (int i = 0; i < k; i++) {
            ret[i] = pq.poll();
        }
        return ret;
    }
    public static void main(String[] args) {
        int[] array = {10,3,11,4,8,20};
        int[] ret = topK(array,3);
        System.out.println(Arrays.toString(ret));
    }
}

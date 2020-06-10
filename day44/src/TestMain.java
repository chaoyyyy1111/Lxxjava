import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Scanner;

class Node {
    public int val;
    public Node next;
    public Node(int val) {

        this.val = val;
    }
}
public class TestMain {
    public static void main1(String[] args) {
        Scanner scan = new Scanner(System.in);
        int n = scan.nextInt();
        Node head = new Node(0);
        Node cur = head;
        for (int i = 1; i < n ; i++) {
            cur.next = new Node(i);
            cur = cur.next;
        }
        cur.next = head;
        Node pre = cur;
        while(pre.next != pre) {
            pre = pre.next.next;
            pre.next = pre.next.next;
        }
        System.out.println(pre.val);
    }

    public static void main(String[] args) {
        PriorityQueue<Integer> pq = new PriorityQueue<>(new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                return o2 - o1;
            }
        });
        Scanner scan = new Scanner(System.in);
        String str = scan.nextLine();
        String[] strs = str.split(" ");
        int[] nums = new int[strs.length];
        for (int i = 0; i < strs.length ; i++) {
            nums[i] = Integer.parseInt(strs[i]);
        }
        int k = nums[nums.length-1];
        for (int i = 0; i < nums.length-1 ; i++) {
            if(i < k) {
                pq.add(nums[i]);
            } else {
                if(nums[i] < pq.peek()) {
                    pq.poll();
                    pq.add(nums[i]);
                }
            }
        }
        int[] ret = new int[k];
        for (int i = 0; i < k ; i++) {
            ret[i] = pq.poll();
        }
        Arrays.sort(ret);
        for (int a:ret) {
            System.out.print(a+" ");
        }
    }
}

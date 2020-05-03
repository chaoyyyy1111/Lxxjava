 class ListNode {
      int val;
      ListNode next;
      ListNode(int x) { val = x; }
  }
class Solution {
    public static ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode cur1 = l1;
        ListNode cur2 = l2;
        long ret1 = 0;
        int count = 0;
        while(cur1 != null) {
            ret1 += (cur1.val)*((int)(Math.pow(10,count)));
            count++;
            cur1 = cur1.next;
        }
        long ret2 = 0;
        count = 0;
        while(cur2 != null) {
            ret2 += (cur2.val)*(Math.pow(10,count));
            count++;
            cur2 = cur2.next;
        }
        long ret3 = ret1 +ret2;
        ListNode newHead = new ListNode(-1);
        ListNode tmp = newHead;
        if(ret3 == 0) {
            ListNode cur = new ListNode(0);
            tmp.next = cur;
        } else {
            while(ret3 != 0) {
                ListNode cur = new ListNode((int)(ret3%10));
                ret3 /= 10;
                tmp.next = cur;
                tmp = tmp.next;
            }
        }

        return newHead.next;
    }
}
public class Test extends Solution{
    public static void main(String[] args) {
        ListNode l1 = new ListNode(9);
        ListNode cur = l1;

        ListNode l2 = new ListNode(1);
        ListNode cur1 = l2;
        int index = 9;
        while(index != 0) {
            ListNode node1 = new ListNode(9);
            cur1.next = node1;
            cur1= cur1.next;
            index--;
        }

        ListNode head = addTwoNumbers(l1,l2);
        while(head != null) {
            System.out.println(head.val);
            head = head.next;
        }

    }

}

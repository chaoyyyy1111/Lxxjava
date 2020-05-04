class ListNode {
    int val;
    ListNode next;
    ListNode(int x) { val = x; }
}
public class Test {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode cur1 = l1;
        ListNode cur2 = l2;
        ListNode newHead = new ListNode(0);
        ListNode tmp = newHead;
        int carry = 0;
        while(cur1 != null || cur2 != null) {
            int ret1 = (cur1 != null) ? cur1.val : 0;
            int ret2 = (cur2 != null) ? cur2.val : 0;
            int sum = carry + ret1 + ret2;
            carry = sum/10;
            tmp.next = new ListNode(sum % 10);
            tmp = tmp.next;
            if(cur1 != null) {
                cur1 = cur1.next;
            }
            if(cur2 != null) {
                cur2 = cur2.next;
            }
        }
        if(carry != 0) {
            tmp.next = new ListNode(carry);
        }
        return newHead.next;
    }
    public void reorderList(ListNode head) {
        ListNode node = head;
        int count = 0;
        while(node != null) {
            node = node.next;
            count++;
        }
        ListNode slow = head;
        ListNode fast = head;
        while(fast != null && fast.next != null) {
            fast = fast.next.next;
            slow = slow.next;
        }
        ListNode prev = null;
        while(slow != null) {
            ListNode slowNext = slow.next;
            slow.next = prev;
            prev = slow;
            slow = slowNext;
        }
        ListNode newHead = new ListNode(-1);
        ListNode tmp = newHead;
        if(count % 2 == 0) {
            while(prev != null && head.next != null) {
                tmp.next = head;
                tmp = tmp.next;
                head = head.next;
                tmp.next = prev;
                tmp = tmp.next;
                prev = prev.next;
            }
        } else {
            while(head.next != null && prev.next != null) {
                tmp.next = head;
                tmp = tmp.next;
                head = head.next;
                tmp.next = prev;
                tmp = tmp.next;
                prev = prev.next;
            }
            tmp.next = prev;
        }
        head = newHead.next;
    }
    public int[] nextLargerNodes(ListNode head) {
        int count = 0;
        ListNode cur = head;
        while(cur != null) {
            cur = cur.next;
            count++;
        }

        int[] tmp = new int[count];
        int i = 0;
        while(head != null) {
            cur = head.next;
            while(cur != null) {
                if(head.val < cur.val) {
                    tmp[i] = cur.val;
                    i++;
                    break;
                }
                cur = cur.next;
            }
            if(cur == null) {
                tmp[i] = 0;
                i++;
            }
            head = head.next;
        }
        return tmp;
    }
    public void deleteNode(ListNode node) {
        node.val = node.next.val;
        node.next = node.next.next;
    }

}

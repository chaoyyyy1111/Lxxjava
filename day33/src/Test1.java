public class Test1 {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode newHead1 = null;
        ListNode prev1 = null;
        ListNode cur1 = l1;
        while(cur1 != null) {
            ListNode curNext = cur1.next;
            if(curNext == null) {
                newHead1 = cur1;
            }
            cur1.next = prev1;
            prev1 = cur1;
            cur1 = curNext;
        }
        ListNode newHead2 = null;
        ListNode prev2 = null;
        ListNode cur2 = l2;
        while(cur2 != null) {
            ListNode curNext = cur2.next;
            if(curNext == null) {
                newHead2 = cur2;
            }
            cur2.next = prev2;
            prev2 = cur2;
            cur2 = curNext;
        }

        ListNode newHead = new ListNode(-1);
        ListNode tmp = newHead;
        int carry = 0;
        cur1 = newHead1;
        cur2 = newHead2;
        while(cur1 != null || cur2 != null) {
            int ret1 = cur1 != null ? cur1.val : 0;
            int ret2 = cur2 != null ? cur2.val : 0;
            int sum = carry + ret1 +ret2;
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
        ListNode newHead3 = null;
        ListNode prev = null;
        ListNode cur = newHead.next;
        while(cur != null) {
            ListNode curNext = cur.next;
            if(curNext == null) {
                newHead3 = cur;
            }
            cur.next = prev;
            prev = cur;
            cur = curNext;
        }

        return newHead3;
    }
    public ListNode rotateRight(ListNode head, int k) {
        if(head == null || head.next == null) {
            return head;
        }
        ListNode tail = head;
        int length = 1;
        while(tail.next != null) {
            tail = tail.next;
            length++;
        }
        tail.next = head;
        if(k >= length) {
            k = k % length;
        }
        int index = length - k -1;
        tail = head;
        while(index != 0) {
            tail = tail.next;
            index--;
        }
        head = tail.next;
        tail.next = null;
        return head;
    }
    public ListNode oddEvenList(ListNode head) {
        ListNode bs = null;
        ListNode be = null;
        ListNode as = null;
        ListNode ae = null;
        ListNode cur = head;
        int count = 1;
        while(cur != null) {
            if(count % 2 != 0) {
                if(bs == null) {
                    bs = cur;
                    be = cur;
                } else {
                    be.next = cur;
                    be = be.next;
                }
                count++;
            } else {
                if(as == null) {
                    as = cur;
                    ae = cur;
                } else {
                    ae.next = cur;
                    ae = ae.next;
                }
                count++;
            }
            cur = cur.next;
        }
        if(bs == null) {
            return null;
        }
        be.next = as;
        if(as != null){
            ae.next = null;
        }
        return bs;
    }
    public ListNode deleteDuplicates(ListNode head) {
        if(head == null || head.next == null) {
            return head;
        }
        ListNode pre = new ListNode(-1);
        ListNode newHead = pre;
        pre.next = head;
        ListNode cur = head;
        ListNode curNext = cur.next;
        while(cur != null && curNext != null) {
            if(cur.val == curNext.val) {
                while(curNext != null && cur.val == curNext.val) {
                    cur = cur.next;
                    curNext = cur.next;
                }
                pre.next = curNext;
                if(curNext != null) {
                    cur = pre.next;
                }
                if(cur != null) {
                    curNext = cur.next;
                }
            } else {
                pre = pre.next;
                cur = pre.next;
                curNext = cur.next;
            }

        }
        return newHead.next;
    }
}

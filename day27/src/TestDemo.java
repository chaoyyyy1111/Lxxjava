import java.util.Scanner;

public class TestDemo {
    public static void main(String[] args) {
       /* MyLinkedList myLinkedList = new MyLinkedList();

        for (int i = 0; i < 5; i++) {
            myLinkedList.addIndex(i,i);
        }
        myLinkedList.clear();
        System.out.println("hahahahahaha");
        myLinkedList.display();
        Node ret = myLinkedList.middleNode();
        System.out.println(ret.data);
        Node ret1 = myLinkedList.middleK(1);
        System.out.println(ret1.data);
        */



    }
    public static void creatCut(Node headA, Node headB) {
        headA.next = headB.next.next;
    }
    public static Node getIntersectionNode(Node headA, Node headB) {
        int lenA = 0;
        int lenB = 0;
        Node pl = headA;
        Node ps = headB;
        while(pl != null) {
            pl = pl.next;
            lenA++;
        }
        while(ps != null) {
            ps = ps.next;
            lenB++;
        }
        int len = lenA-lenB;
        pl = headA;
        ps = headB;
        if(len < 0) {
            pl = headB;
            ps = headA;
            len = lenB - lenA;
        }
        for (int i = 0; i < len; i++) {
            pl = pl.next;
        }
        while(pl != ps) {
            pl = pl.next;
            ps = ps.next;
        }
        if(pl != null) {
            return pl;
        }
        return null;
    }
    public Node mergeTwoLists(Node headA, Node headB) {
        Node newHead = new Node(-1);
        Node tmp = newHead;
        while(headA != null && headB != null) {
            if(headA.data < headB.data) {
                tmp.next = headA;
                tmp = tmp.next;
                headA = headA.next;
            } else {
                tmp.next = headB;
                tmp = tmp.next;
                headB = headB.next;
            }
        }
        if(headA != null) {
            tmp.next = headA;
        } else {
            tmp.next = headB;
        }
        return newHead.next;
    }

}

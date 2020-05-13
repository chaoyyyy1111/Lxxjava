class Node {
    public int val;
    public Node next;
    public Node(int val) {
        this.val = val;

    }
}
public class MyLinkedList {
    public Node head;
    public void addFirst(int val) {
        Node node = new Node(val);
        if(this.head == null) {
            this.head = node;
            return;
        }
        node.next = head;
        this.head = node;
    }
    public void addLast(int val) {
        Node node = new Node(val);
        if(this.head == null) {
            this.head = node;
            return;
        }
        Node cur = this.head;
        while(cur.next != null) {
            cur = cur.next;
        }
        cur.next = node;
    }
    public int size() {
        Node cur = this.head;
        int count = 0;
        while(cur != null) {
            cur = cur.next;
            count++;
        }
        return count;
    }
    public Node searchPerv(int index) {
        Node cur = this.head;
        while(index-1 != 0) {
            cur = cur.next;
            index--;
        }
        return cur;
    }
    public void addIndex(int index,int val) throws RuntimeException {
        Node node = new Node(val);
        if(index < 0 || index > size()) {
            throw new RuntimeException("pos位置不合法");
        }
        if(index == 0) {
            addFirst(val);
            return;
        }
        if(index == size()) {
            addLast(val);
            return;
        }
        Node cur = searchPerv(index);
        node.next = cur.next;
        cur.next = node;
    }
    public boolean contains(int key) {
        if(this.head == null) {
            return false;
        }
        Node cur = this.head;
        while(cur != null) {
            if(cur.val == key) {
                return true;
            }
            cur = cur.next;
        }
        return false;
    }
    public void remove(int key) {
        if(this.head == null) {
            return;
        }
        if(this.head.val == key) {
            this.head = this.head.next;
            return;
        }
        Node prev = this.head;
        while(prev.next != null) {
            if(prev.next.val == key) {
                prev.next = prev.next.next;
            }
            prev = prev.next;
        }
    }
    public void removeAllKey(int key) {
        if(this.head == null) {
            return;
        }
        Node prev = this.head;
        Node cur = this.head.next;
        while(cur != null) {
            if(cur.val == key) {
                prev.next = cur.next;
                cur = cur.next;
            } else {
                prev = prev.next;
                cur = cur.next;
            }
        }
        if(this.head.val == key) {
            this.head = this.head.next;
        }
    }
    public void display() {
        Node cur = this.head;
        while(cur != null) {
            System.out.print(cur.val);
        }
        System.out.println();
    }
    public void clear() {
        this.head = null;
    }

}

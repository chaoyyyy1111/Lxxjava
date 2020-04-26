class Node {
    public int data;
    public Node next;
    public Node(int data) {
        this.data = data;
        this.next = null;
    }
}
public class MyLinkedList {
    public Node head;
    public void addFirst(int data) {
        Node node = new Node(data);
        if(this.head == null) {
            this.head = node;
        } else {
            node.next = this.head;
            this.head = node;
        }
    }
    public void addLast(int data) {
        Node node = new Node(data);
        if(this.head == null) {
            this.head = node;
        } else {
            Node cur = this.head;
            while(cur.next != null) {
                cur = cur.next;
            }
            cur.next = node;
        }
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
    private Node searchPrev (int index) {
        Node cur = this.head;
        while(index - 1 != 0) {
            cur = cur.next;
            index--;
        }
        return cur;
    }
    public void addIndex(int index,int data) {
        Node node = new Node(data);
        if(index < 0 || index > size()) {
            throw new RuntimeException("index不合法");
        }
        if(index == 0) {
            addFirst(data);
            return;
        }
        if(index == size()) {
            addLast(data);
            return;
        }
        Node prev = searchPrev (index);
        node.next = prev.next;
        prev.next = node;
    }
    public boolean contains(int key) {
        Node cur = this.head;
        while(cur != null) {
            if(cur.data == key) {
                return true;
            }
            cur = cur.next;
        }
        return false;
    }
    public void display () {
        Node cur = this.head;
        while(cur != null) {
            System.out.print(cur.data+" ");
            cur = cur.next;
        }
        System.out.println();
    }
    public void clear() {
        this.head = null;
    }
    public void remove(int key) {
        if(this.head == null) {
            return;
        }
        if(this.head.data == key) {
            this.head = this.head.next;
            return;
        }
        Node prev = this.head;
        while(prev.next != null) {
            if(prev.next.data == key) {
                Node del = prev.next;
                prev.next = del.next;
            }
            prev = prev.next;
        }
    }


}

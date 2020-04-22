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
    if (this.head == null) {
        this.head = node;
        return;
    }
        node.next = this.head;
        this.head = node;

}
public void addLast(int data) {
    Node node = new Node(data);
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
public void display() {
    Node cur = this.head;
    while(cur != null) {
        System.out.print(cur.data+" ");
        cur = cur.next;
    }
    System.out.println();
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
public int size() {
    int count = 0;
    Node cur = this.head;
    while(cur != null) {
        count++;
        cur = cur.next;
    }
    return count;
}
private Node searchIndex(int index) {
        if(index < 0||index > this.size()) {
            throw new RuntimeException("pos位置不合法");
        }
        Node cur = this.head;
        while(index-1 != 0) {
            cur = cur.next;
            index--;
        }
        return cur;
    }
public void addIndex(int index,int data) {

    if(index == 0) {
        addFirst(data);
        return;
    }
    if(index == this.size()) {
        addLast(data);
        return;
    }
    Node node = new Node(data);
    Node cur = searchIndex((index));
    node.next = cur.next;
    cur.next = node;
}
private int search(int key) {
        Node cur = this.head;
        int count = 0;
        while(cur != null) {
            if(cur.data == key) {
                return count;
            }
            count++;
            cur = cur.next;
        }
        throw new RuntimeException("找不到该数字");
    }
public void remove(int key) {
    int index = search(key);
    if(index == 0) {
        this.head = this.head.next;
        return;
    }
    if(index == size()-1) {
        Node cur = searchIndex(size()-1);
        cur.next = null;
        return;
    }
    Node cur = searchIndex(index+1);
    Node curBefore = searchIndex(index);
    curBefore.next = cur.next;
}
public void removeAllKey(int key) {
    while(contains(key)) {
        int index = search(key);
        if(index == 0) {
            this.head = this.head.next;
            return;
        }
        if(index == size()-1) {
            Node cur = searchIndex(size()-1);
            cur.next = null;
            return;
        }
        Node cur = searchIndex(index+1);
        Node curBefore = searchIndex(index);
        curBefore.next = cur.next;
    }
}
public void clear() {
    this.head = null;
}
}

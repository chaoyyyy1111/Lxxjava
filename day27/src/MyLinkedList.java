import com.sun.xml.internal.ws.api.model.wsdl.WSDLOutput;

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
    public void addFirst1(Node cur) {
        Node node = cur;
        if (this.head == null) {
            this.head = node;
            return;
        }
        node.next = this.head;
        this.head = node;

    }
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
    public void display2(Node newHead) {
        Node cur = newHead;
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
public Node middleNode() {
    Node fast = this.head;
    Node slow = this.head;
    while(fast != null && fast.next != null) {
        fast = fast.next.next;
        slow = slow.next;
    }
    return slow;
    }
public Node middleK(int key) {
     Node fast = this.head;
     Node slow = this.head;
     while(key - 1 != 0) {
         fast = fast.next;
         key--;
     }
     while(fast.next != null) {
         fast = fast.next;
         slow = slow.next;
     }
return slow;
    }
public Node reverse() {
    Node prev = null;
    Node cur = this.head;
    Node newHead = cur.next;
    while(cur != null) {
        Node curNext = cur.next;//防止空指针异常
        if(curNext == null) {
            newHead = cur;
        }
        cur.next = prev;
        prev = cur;
        cur = curNext;
    }
    return newHead;
}
public Node reverseHead() {
        if (this.head == null) {
            return null;
        }
        Node cur = this.head.next;
        Node curNext = cur.next;
        Node newHead = null;
        this.head.next = null;
        while (cur != null) {
            curNext = cur.next;
            if (cur.next == null) {
                newHead = cur;
            }
            addFirst1(cur);
            cur = curNext;
        }
        return newHead;
    }
private Node searchPrev(int key) {
    Node prev = this.head;
    while(prev.next != null) {
        if(prev.next.data == key) {
            return prev;
        } else {
            prev = prev.next;
        }
    }
    return null;
}
public void remove(int key) {
    if(this.head == null) {
       return;
    }
    if(this.head.data == key) {
        this.head = this.head.next;
    }
    Node prev = searchPrev(key);
    if(prev == null) {
        System.out.println("找不到该数字");
        return;
    }
    Node del = prev.next;
    prev.next = del.next;
}

public void removeAllKey(int key) {
    Node prev = this.head;
    Node cur = this.head.next;
    while(cur != null) {
        if(cur.data == key) {
            prev.next = cur.next;
            cur = cur.next;
        } else {
            prev = cur;
            cur = cur.next;
        }
    }
    if(this.head.data == key) {
        this.head = this.head.next;
    }
}

public void clear() {
    this.head = null;
}
}

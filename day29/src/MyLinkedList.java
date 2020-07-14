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
    //头插法
    public void addFirst(int data) {
        Node node = new Node(data);
        if(this.head == null) {
            this.head = node;
        } else {
            node.next = this.head;
            this.head = node;
        }
    }
    //尾插法
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
    //任意位置插入,第一个数据节点为0号下标
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
    private Node searchPrev (int index) {
        Node cur = this.head;
        while(index - 1 != 0) {
            cur = cur.next;
            index--;
        }
        return cur;
    }
    //查找是否包含关键字key
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
    //删除第一次出现关键字为key的节点
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
    //删除所有值为key的节点
    public void removeAllKey(int key) {
        if(this.head == null) {
            return;
        }
        Node prev = this.head;
        Node cur = this.head.next;
        Node newHead = null;
        while(cur != null) {
            Node curNext = cur.next;
            if(cur.next == null) {
                newHead = cur;
            }
            prev.next = cur.next;
            prev = cur;
            cur = curNext;
        }
        if(this.head.data == key) {
            this.head = this.head.next;
        }
    }
    //得到单链表的长度
    public int size() {
        Node cur = this.head;
        int count = 0;
        while(cur != null) {
            cur = cur.next;
            count++;
        }
        return count;
    }
    //打印单链表
    public void display () {
        Node cur = this.head;
        while(cur != null) {
            System.out.print(cur.data+" ");
            cur = cur.next;
        }
        System.out.println();
    }
    //清空单链表
    public void clear() {
        this.head = null;
    }


}

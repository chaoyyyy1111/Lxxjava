public class TestDemo {
    public static void main(String[] args) {
        MyLinkedList myLinkedList = new MyLinkedList();

        for (int i = 0; i < 5; i++) {
            myLinkedList.addIndex(i,i);
        }
        myLinkedList.display();
        Node ret = myLinkedList.middleNode();
        System.out.println(ret.data);
        Node ret1 = myLinkedList.middleK(1);
        System.out.println(ret1.data);



    }
}

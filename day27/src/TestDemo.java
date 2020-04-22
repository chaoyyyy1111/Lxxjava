public class TestDemo {
    public static void main(String[] args) {
        MyLinkedList myLinkedList = new MyLinkedList();
        myLinkedList.addIndex(0,0);
        for (int i = 1; i < 5; i++) {
            myLinkedList.addIndex(i,5);
        }
        System.out.println(myLinkedList.contains(5));
        System.out.println(myLinkedList.size());
        myLinkedList.display();
        myLinkedList.remove(5);
        myLinkedList.display();
        myLinkedList.removeAllKey(5);
        myLinkedList.display();
        myLinkedList.clear();
        myLinkedList.display();

    }
}

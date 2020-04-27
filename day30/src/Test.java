public class Test {
    public static void main(String[] args) {
        MyLinkedList myLinkedList = new MyLinkedList();
        myLinkedList.addIndex(0,4);
        myLinkedList.addIndex(1,4);
        myLinkedList.addIndex(2,3);
        myLinkedList.addIndex(3,4);
        myLinkedList.addIndex(4,4);
        myLinkedList.display();
        myLinkedList.remove(4);
        myLinkedList.display();
        myLinkedList.removeAllKey(4);
        myLinkedList.display();
        myLinkedList.clear();
        myLinkedList.display();
    }



}

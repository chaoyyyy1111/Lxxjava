public class Test {
    public static void main(String[] args) {
        MyLinkedList myLinkedList = new MyLinkedList();
        myLinkedList.addIndex(0,1);
        myLinkedList.addIndex(1,2);
        myLinkedList.addIndex(2,3);
        myLinkedList.addIndex(3,3);
        myLinkedList.addIndex(4,4);
        myLinkedList.display();
        myLinkedList.remove(2);
        myLinkedList.display();
        System.out.println(myLinkedList.size());


    }
}

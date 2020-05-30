public class TestMain {
    public static void main1(String[] args) {
        BSTree bsTree = new BSTree();
        int[] array = {2,3,1,5,7,9,11};
        for(int i:array) {
            bsTree.insert(i);
        }
        bsTree.preOrder(bsTree.root);
        System.out.println();
        bsTree.inOrder(bsTree.root);

    }

    public static void main2(String[] args) {
        HashBuck hashBuck = new HashBuck();
        for (int i = 0; i < 8 ; i++) {
            hashBuck.put(i,i);
        }
        hashBuck.put(11,11);
        System.out.println("================");
    }

    public static void main(String[] args) {
        Person person1 = new Person(12);
        Person person2 = new Person(12);
        HashBuck2<Person,String> hb = new HashBuck2<>();
        hb.put(person1,"lxx");
        System.out.println(hb.get(person2));
    }
}

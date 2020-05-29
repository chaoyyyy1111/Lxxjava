public class TestMain {
    public static void main(String[] args) {
        BSTree bsTree = new BSTree();
        int[] array = {2,3,1,5,7,9,11};
        for(int i:array) {
            bsTree.insert(i);
        }
        bsTree.preOrder(bsTree.root);
        System.out.println();
        bsTree.inOrder(bsTree.root);

    }
}

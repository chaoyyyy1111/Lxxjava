import java.util.LinkedList;
import java.util.Queue;

public class TestMain {
    public static void main(String[] args) {
        BinaryTree binaryTree = new BinaryTree();
        Node root = binaryTree.buildTree();
        binaryTree.inOrderTraversalNor(root);
        binaryTree.getSize1(root);
        System.out.println(BinaryTree.size);
        System.out.println(binaryTree.getSize2(root));
        binaryTree.getLeafSize1(root);
        System.out.println(BinaryTree.leafSize);
        System.out.println(binaryTree.getLeafSize2(root));
        System.out.println(binaryTree.getHeight(root));
        Node ret = binaryTree.find(root, 'E');
        System.out.println(ret.val);
        String str = "123";
        int a = 0;

    }
}

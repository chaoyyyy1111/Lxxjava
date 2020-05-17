class Node {
    public Node left;
    public Node right;
    public char val;
    public Node(char val) {
        this.val = val;
    }
}
public class BinaryTree {
    public static Node buildTree() {
        Node A = new Node('A');
        Node B = new Node('B');
        Node C = new Node('C');
        Node D = new Node('D');
        Node E = new Node('E');
        Node F = new Node('F');
        Node G = new Node('G');
        Node H = new Node('H');
        A.left = B;
        A.right = C;
        B.left = D;
        B.right = E;
        C.left = F;
        C.right = G;
        E.right = H;
        return A;
    }
    // 前序遍历   递归来实现
    void preOrderTraversal(Node root){
        if(root == null) {
            return;
        }
        System.out.print(root.val+" ");
        preOrderTraversal(root.left);
        preOrderTraversal(root.right);
    }

    // 中序遍历
    void inOrderTraversal(Node root){
        if(root == null) {
            return;
        }
        inOrderTraversal(root.left);
        System.out.print(root.val+" ");
        inOrderTraversal(root.right);
    }
    // 后序遍历
    void postOrderTraversal(Node root){
        if(root == null) {
            return;
        }
        postOrderTraversal(root.left);
        postOrderTraversal(root.right);
        System.out.print(root.val+" ");
    }
    static int size;
    void getSize1(Node root) {
        if(root == null) {
            return;
        }
        size++;
        getSize1(root.left);
        getSize1(root.right);
    }
    int getSize2(Node root) {
        if(root == null) {
            return 0;
        }
        return getSize2(root.left)+getSize2(root.right)+1;
    }
    static int leafSize;
    void getLeafSize1(Node root) {
        if(root == null) {
            return;
        }
        if(root.right == null && root.left == null) {
            leafSize++;
        }
        getLeafSize1(root.left);
        getLeafSize1(root.right);
    }
    int getLeafSize2(Node root) {
        if(root == null) {
            return 0;
        }
        if(root.left == null && root.right == null) {
            return 1;
        }
        return getLeafSize2(root.left)+getLeafSize2(root.right);
    }

    int getKLevelSize(Node root , int k) {
        if(root == null ) {
            return 0;
        }
        if(k == 1) {
            return 1;
        }
        return getKLevelSize(root.left,k-1) + getKLevelSize(root.right,k-1);
    }
    // 获取二叉树的高度
    int getHeight(Node root) {
        if(root == null) {
            return 0;
        }
        return Math.max(getHeight(root.left),getHeight(root.right))+1;
    }

    Node find(Node root, int val){
        if(root == null) {
            return null;
        }
        if(root.val == val) {
            return root;
        }
        Node left = find(root.left,val);
        if(left.val == val) {
            return left;
        }
        Node right = find(root.right,val);
        if(right.val == val ) {
            return right;
        }
        return null;
    }

    public boolean isSubtree(Node s, Node t) {
        if(s == null || t == null) {
            return false;
        }
        if(isSameTree(s,t)) {
            return true;
        }
        if(isSubtree(s.left,t)) {
            return true;
        }
        return isSubtree(s.right,t);
    }

    public boolean isSameTree(Node p, Node q) {
        if( (p == null && q != null)   || (p != null && q == null)) {
            return false;
        }
        if(p == null && q == null) {
            return true;
        }

        if(p.val != q.val) {
            return false;
        }

        return isSameTree(p.left,q.left) && isSameTree(p.right,q.right);
    }
    class Solution {
        public boolean isSymmetric(Node root) {
            if(root == null) {
                return true;
            }
           return Math.abs(maxDepth(root.right) - maxDepth(root.right)) <= 1 &&
                   isSymmetric(root.left) && isSymmetric(root.right);
        }
        public int maxDepth(Node root) {
            if(root == null) {
                return 0;
            }
            int leftHeight = maxDepth(root.left);
            int rightHeight = maxDepth(root.right);

            return leftHeight >  rightHeight? leftHeight+1 :
                    rightHeight+1;
        }
    }
    public boolean isSymmctricChild(Node leftTree,Node rightTree) {
        if(leftTree != null && rightTree == null ||leftTree == null && rightTree != null) {
            return false;
        }
        if(leftTree == null && rightTree == null) {
            return true;
        }
        return leftTree.val == rightTree.val && isSymmctricChild(leftTree.left,rightTree.right) &&
                isSymmctricChild(leftTree.right,rightTree.left);
    }
}
import java.util.*;

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
    void levelOrderTraversal(Node root){

        if(root == null) {
            return;
        }
        Queue<Node> queue = new LinkedList<>();
        queue.offer(root);
        while(!queue.isEmpty()) {
            Node cur = queue.poll();
            if(cur != null) {
                System.out.print(cur.val+"");
                if(cur.left != null) {
                    queue.offer(cur.left);
                }
                if(cur.right != null) {
                    queue.offer(cur.right);
                }
            }
        }
        System.out.println();

    }
    public List<List<Character>> levelOrder(Node root) {
        List<List<Character>> ret = new ArrayList<>();
        if(root == null) {
            return ret;
        }
        Queue<Node> queue = new LinkedList<>();
        queue.offer(root);
        while(!queue.isEmpty()) {
            List<Character> list = new ArrayList<>();
            int qSize = queue.size();
            while(qSize > 0) {
                Node cur = queue.poll();
                if(cur != null) {
                    list.add(cur.val);
                    if(cur.left != null) {
                        queue.offer(cur.left);
                    }
                    if(cur.right != null) {
                        queue.offer(cur.right);
                    }
                }
                qSize--;
            }
            ret.add(list);
        }
        return ret;
    }
    public boolean isCompleteTree(Node root) {
        Queue<Node> queue = new LinkedList<>();
        if(root == null) {
            return true;
        }
        queue.offer(root);
        while(!queue.isEmpty()) {
            Node cur = queue.poll();
            if(cur != null) {
                queue.offer(cur.left);
                queue.offer(cur.right);
            } else {
                break;
            }
        }
        while(!queue.isEmpty()) {
            if(queue.poll() != null) {
                return false;
            }
        }
        return true;
    }
    // 中序遍历
    void inOrderTraversalNor(Node root){
        Stack<Node> stack = new Stack<>();
        if(root == null) {
            return;
        }
        Node cur = root;
        while(cur != null || !stack.empty()) {
            while(cur != null) {
                stack.push(cur);
                cur = cur.left;
            }
            Node top = stack.pop();
            System.out.print(top+" ");
            cur = top.right;
        }
    }
    void postOrderTraversalNor(Node root) {
        Stack<Node> stack = new Stack<>();
        if(root == null) {
            return;
        }
        Node cur = root;
        Node prev = null;
        while(cur != null || !stack.empty()) {
            while(cur != null ) {
                stack.push(cur);
                cur = cur.left;
            }
            cur = stack.peek();
            if(cur.right == null || cur.right == prev) {
                System.out.print(cur.val);
                stack.pop();
                prev = cur;
                cur = null;
            } else {
                cur = cur.right;
            }
        }
    }
    public Node prev = null;
    public void func (Node root) {
        if(root == null) {
            return;
        }
        func(root.left);
        root.left = prev;
        if(prev != null) {
            prev.right = root;
        }
        prev = root;
        func(root.right);
    }
    public Node increasingBST(Node root) {
        if(root == null) {
            return null;
        }
        func(root);
        Node head = root;
        while(head.left != null) {
            head = head.left;
        }
        while(prev != head) {
            Node prevLeft = prev.left;
            prev.left = null;
            prev = prevLeft;
        }
        return head;
    }
    public void adjustDown(int root,int len) {
        int parent = root;
        int child = 2*parent+1;
        while (child < len) {
            //0、判断是否有左右孩子  有的话 找到最大值 C下标表示最大值下标
            if(child + 1 < len) {
                  if(this.elem[child+1] > this.elem[child]) {
                      child = child+1;
                  }
            }
            //代码指向到这里，c表示最大值下标
            if(this.elem[child] > this.elem[parent]) {
                //交换
                int tmp = this.elem[child];
                this.elem[child] = this.elem[parent];
                this.elem[parent] = tmp;
            }else {
                break;
            }
            parent = child;
            child = 2*parent + 1;
        }

    }
}
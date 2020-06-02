
public class BSTree {
public static class Node {
    public int val;
    public Node left;
    public Node right;
    public Node(int val) {
        this.val = val;
    }
}
public Node root = null;
public boolean insert(int val) {
    Node node = new Node(val);
    if(root == null) {
        root = node;
        return true;
    }
    Node parent = null;
    Node cur = root;
    while(cur != null) {
        if(cur.val == val) {
            return false;
        } else if(cur.val < val) {
            parent = cur;
            cur = cur.right;
        } else {
            parent = cur;
            cur = cur.left;
        }
    }
    if(parent.val < val) {
        parent.right = node;
    } else {
        parent.left = node;
    }
    return true;
}
public Node search(int key) {
    Node cur = root;
    while(cur != null) {
        if(cur.val == key) {
            return cur;
        } else if(cur.val > key) {
            cur = cur.left;
        } else {
            cur = cur.right;
        }
    }
    return null;
}
public void removeNode(Node parent,Node cur) {
       if(cur.left == null) {
           if(cur == root) {
               root = cur.right;
           } else if(parent.left == cur) {
               parent.left = cur.right;
           } else {
               parent.right = cur.right;
           }
       } else if(cur.right == null) {
           if(cur == root) {
               root = cur.left;
           } else if(parent.left == cur) {
               parent.left = cur.left;
           } else {
               parent.right = cur.left;
           }
       } else {
           Node targetP = cur;
           Node target = cur.right;
           while(target.left != null) {
               targetP = target;
               target = target.left;
           }
           cur.val = target.val;
           if(targetP.left == target) {
               targetP.left = target.right;
           } else {
               targetP.right = target.right;
           }
       }
}
public boolean remove(int key) {
       Node parent = null;
       Node cur = root;
       while(cur != null) {
           if(cur.val == key) {
               removeNode(parent,cur);
               return true;
           } else if(cur.val > key) {
               parent = cur;
               cur = cur.left;
           } else {
               parent = cur;
               cur = cur.left;
           }
       }
       return false;
}
public void preOrder(Node root) {

    if(root == null) {
        return;
    }
    System.out.print(root.val+" ");
    preOrder(root.left);
    preOrder(root.right);
}
    public void inOrder(Node root) {
        if(root == null) {
            return;
        }
        preOrder(root.left);
        System.out.print(root.val+" ");
        preOrder(root.right);
    }
}

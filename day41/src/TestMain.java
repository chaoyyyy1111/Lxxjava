import java.util.*;

class Student {
    public int age;
    public String name;
    public static int count;
    public final int size = 10;
    public static final int COUNT = 99;
    public static void func() {
        
        count = 0;
    }
    public void func1() {

    }
}
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
    public static int partition(int[] a,int left,int right) {
        int tmp = a[left];
        while(left < right) {
            while(left < right && a[right] >= tmp) {
                right--;
            }
            a[left] = a[right];
            while(left < right && a[left] <= tmp) {
                left++;
            }
            a[right] = a[left];
        }
        a[left] = tmp;
        return left;
    }
    public static int findKth(int[] a, int n, int K) {
        // write code here
        Arrays.sort(a);
        int left = 0;
        int right = n-1;
        Stack<Integer> stack = new Stack<>();
        stack.push(left);
        stack.push(right);
        int ret = 0;;
        while(!stack.empty()) {
            right = stack.pop();
            left = stack.pop();
            int par = partition(a,left,right);

            if(par == K-1) {
                ret = a[par];
                break;
            }
            if(left+1 < par) {
                stack.push(left);
                stack.push(par-1);
            }
            if(par+1 < right) {
                stack.push(par+1);
                stack.push(right);
            }
        }
        return ret;
    }

    public static int func(int n) {
        int count = 0;
        while(n/3 != 0) {
            count += n/3;
            n = n/3 + n % 3;
            if(n == 2) {
                n++;
            }
        }
        return count;
    }

    public static void main(String[] args) {
        /*Scanner scan = new Scanner(System.in);
        Queue<Integer> queue = new LinkedList<>();
        while(scan.hasNext()) {
            int n = scan.nextInt();
            if(n != 0) {
                queue.offer(n);
            } else {
                break;
            }
        }
        while(!queue.isEmpty()) {
            System.out.println(func(queue.poll()));
        }
        System.out.println("==================");
         */
        String str = "abc";
        System.out.println(str.substring(3, 3));

    }


}

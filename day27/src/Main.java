import java.util.Scanner;
public class Main {
    public static int factor(int n) {
        int ret = 1;
        for(int i = 1;i <= n;i++) {
            ret*=i;
        }
        return ret;
    }
    public static int func1(int[] array) {
        int count = 0;
        int ret = count;
        boolean flag = false;
        for(int i = 0;i<array.length;i++) {
            if(array[i]%2 == 0) {
                count++;
                flag = true;
            }
        }
        if(flag) {
            for(int i = 2;i <= count;i++) {
                ret+=factor(count)/factor(i)*(i-1);
            }
        }
        return ret;
    }
    public void FindNumsAppearOnce(int [] array,int num1[] , int num2[]) {
         num1[0] = 0;
         num2[0] = 0;
        int ret = 0;
        for(int i = 0;i < array.length;i++) {
            ret^=array[i];
        }
        int tmp = 0;
        int count = 0;
        while(tmp != 1) {
            tmp=ret%2;
            ret/=2;
            count++;
        }
        for(int i = 0;i < array.length;i++) {
            if((array[i]&(int)(Math.pow(2,count-1)) )== 0){
                 num1[0]^=array[i];
            } else {
                 num2[0]^=array[i];
            }
        }
    }
    public int Sum_Solution(int n) {
        int ret = 0;
        boolean flag = (n > 0)&&(ret+=(Sum_Solution(n - 1)+n))>0;
        return ret;
    }
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int n = scan.nextInt();
        int[] array = new int[n];
        for(int i = 0;i<n;i++) {
            array[i] = scan.nextInt();
        }
        int ret = func1(array);
        System.out.println(ret);
    }
    public int[] printMatrix(int[][] mat, int n, int m) {
        // write code here
        int[] ret = new int[n*m];
        int k = 0;
        for(int i = 0;i < mat.length;i++) {
            if(i % 2 == 0) {
                for(int j = 0;j < mat[0].length;j--) {
                    ret[k] = mat[i][j];
                    k++;
                }
            } else {
                for(int j = mat[0].length-1;j >= 0;j--) {
                    ret[k] = mat[i][j];
                    k++;
                }
            }
        }
        return ret;
    }


}

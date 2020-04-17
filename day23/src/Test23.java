import java.util.Arrays;

public class Test23 {
    public static void main1(String[] args) {
         int[][] array = new int[][]{{1,2,3},{4,5,6}};
          /*int[][] array1 = {{4,5,6},{7,8,9}};
         int[][] array2 = new int[2][3];
        System.out.println(Arrays.deepToString(array));
        System.out.println(Arrays.toString(array));
           */
        for (int i = 0; i < array.length; i++) {
            for (int j = 0; j < array[i].length; j++) {
                System.out.print(array[i][j]+" ");
            }
            System.out.println();
        }
        System.out.println();
        for (int[] x:array) {
            for (int tmp:x) {
                System.out.print(tmp+" ");
            }
            System.out.println();
        }
    }

    public static void main2(String[] args) {
        int[][] array = new int[2][];
        array[0] = new int[]{1,2,3};
        array[1] = new int[]{4,5};
        for (int[] x:array) {
            for (int tmp:x) {
                System.out.print(tmp+" ");
            }
            System.out.println();
        }
        for (int i = 0; i < array.length; i++) {
            for (int j = 0; j < array[i].length; j++) {
                System.out.print(array[i][j]+" ");
            }
            System.out.println();
        }
    }

    public static void main(String[] args) {
        int[] array = {1,1,2,3,3,4};
        int ret = 0;
        int tmp = 0;
        int count = 0;
        for (int i = 0; i < array.length; i++) {
            ret^=array[i];
        }
        while(tmp == 0) {
            tmp = ret&1;
            ret>>=1;
            count++;
        }
        int tmp1 =(int) (Math.pow(2,count-1));
        int ret1 = 0;
        int ret2 = 0;
        for (int i = 0; i < array.length; i++) {
            if((array[i]&tmp1) == tmp1) {
                ret1^=array[i];
            }else {
                ret2^=array[i];
            }
        }
        System.out.println(ret1+" "+ret2);
    }


}

import java.util.Scanner;

public class Test27 {

    public static int FindGreatestSumOfSubArray(int[] array) {
        int tmp = 0;
        int max = array[0];
        for (int i = 0; i < array.length; i++) {
            tmp = 0;
            for (int j = i; j < array.length; j++) {
                tmp+=array[j];
                if(max < tmp) {
                    max = tmp;
                }
            }
        }
        return max;
    }

    public static void main(String[] args) {
        /*int[] array = {0,-10,2,3};
        System.out.println(FindGreatestSumOfSubArray(array));
         */

    }
}

import java.util.Arrays;

public class HomeWork {
    public static void swap(int[] array) {
        int left = 0;
        int right = array.length-1;
        while(left < right) {
            while(left<right && array[left]%2 == 0) {
                left++;
            }
            while(left<right && array[right] %2 != 0) {
                right--;
            }
            if(left<right) {
                int tmp = array[left];
                array[left] = array[right];
                array[right] = tmp;
            }
        }


    }
    public static void main1(String[] args) {
        int[] array = {1,2,3,4,5,6,7};
        swap(array);
        System.out.println(Arrays.toString(array));
    }
    public static void swap1(int[] array1,int[] array2) {
        for (int i = 0; i < array1.length ; i++) {
            int tmp = array1[i];
            array1[i] = array2[i];
            array2[i] = tmp;
        }
    }
    public static void main(String[] args) {
        int[] array1 = {1,2,3,4,5,6,7};
        int[] array2 = new int[7];
        swap1(array1,array2);
        System.out.println(Arrays.toString(array1));
        System.out.println(Arrays.toString(array2));
    }

}

public class Sort {
public void insertSort(int[] array) {
    for(int i = 1;i < array.length;i++) {
        int tmp = array[i];
        int j = i-1;
        for (; j >= 0; j--) {
            if(tmp < array[j]) {
                array[j+1] = array[j];
            } else {
                break;
            }
        }
        array[j+1] = tmp;
    }
}
    public static void shell(int[] array,int gap) {
        for(int i = gap;i < array.length;i++) {
            int tmp = array[i];
            int j = i-gap;
            for (; j >= 0; j-=gap) {
                if(tmp < array[j]) {
                    array[j+gap] = array[j];
                } else {
                    break;
                }
            }
            array[j+gap] = tmp;
        }
    }

    public static  void  shellSort(int[] array) {

        int[] drr = {5,3,1};
        for (int i = 0; i < drr.length; i++) {
            shell(array,drr[i]);
        }

    }
    public static void selectSort(int[] array) {
        for (int i = 0; i <array.length-1 ; i++) {
            int j = i+1;
            for (; j < array.length ; j++) {
                if(array[i] > array[j]) {
                    int tmp = array[i];
                    array[i] = array[j];
                    array[j] = tmp;
                }
            }
        }
    }
}

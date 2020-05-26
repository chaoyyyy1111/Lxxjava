import java.util.Arrays;

public class TestMain {
    public static void main(String[] args) {
        TestSort testSort = new TestSort();
        int[] array = {3,8,6,7,2,10,11,22};
        System.out.println(Arrays.toString(array));
        testSort.mergeSort1(array);
        System.out.println(Arrays.toString(array));
    }
}

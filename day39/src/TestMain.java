import java.util.Arrays;

public class TestMain {
    public static void main(String[] args) {
        TestSort testSort = new TestSort();
        int[] position={2,4};
        int[] speed = {3,2};
        int target = 10;
        System.out.println(testSort.carFleet(target, position, speed));

    }
}

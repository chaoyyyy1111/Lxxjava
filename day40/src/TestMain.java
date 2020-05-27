import java.util.ArrayList;
import java.util.HashSet;
import java.util.Random;


public class TestMain {
    /**
     * 1、找出10W个数据当中，第一个重复的元素。
     * @param args
     */
    public static void main(String[] args) {
        Random random = new Random();
        ArrayList<Integer> list = new ArrayList<>();

        for (int i = 0; i < 10_0000; i++) {
            list.add(random.nextInt(6000));
        }
        HashSet<Integer> hashSet = new HashSet<>();
        /*for (int val:list) {
            if(hashSet.contains(val)) {
                System.out.println(val);
                break;
            } else {
                hashSet.add(val);
            }
        }
         */
        hashSet.addAll(list);
        System.out.println(hashSet);



    }
    public int singleNumber(int[] nums) {
         HashSet<Integer> set = new HashSet<>();
        for (int i = 0; i < nums.length ; i++) {
            if(set.contains(nums[i])) {
                set.remove(nums[i]);
            } else {
                set.add(nums[i]);

            }
        }
    return set.iterator().next();
    }

}

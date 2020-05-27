import java.util.*;

public class TestDemo4 {
    public int singleNumber(int[] nums) {
        HashSet<Integer> hashSet = new HashSet<>();
        for (int i = 0; i < nums.length; i++) {
            if(hashSet.contains(nums[i])) {
                hashSet.remove(nums[i]);
            } else {
                hashSet.add(nums[i]);
            }
        }
        return hashSet.iterator().next();
    }
    public static void main(String[] args) {
        Random random = new Random();
        ArrayList<Integer> list = new ArrayList<>();
        for (int i = 0; i < 100000 ; i++) {
            list.add(random.nextInt(6000));
        }
        HashMap<Integer,Integer> hashMap = new HashMap<>();
        for (Integer val:list) {
            if(!hashMap.containsKey(val)) {
                hashMap.put(val,1);
            } else {
                hashMap.put(val,hashMap.get(val)+1);
            }
        }
        for (Map.Entry<Integer,Integer> entry:hashMap.entrySet()) {
            System.out.println(entry.getKey() + " " + entry.getValue());
        }
    }
    public static void main3(String[] args) {
        Random random = new Random();
        int[] array = new int[100000];
        for (int i = 0; i < array.length ; i++) {
            array[i] = random.nextInt(6000);
        }
        HashSet<Integer> hashSet = new HashSet<>();
        for (int i = 0; i < array.length; i++) {
            if(hashSet.contains(array[i])) {
                System.out.println(array[i]);
                break;
            } else {
                hashSet.add(array[i]);
            }
        }
    }
    public static void main2(String[] args) {
        Set<Integer> set = new HashSet<>();
        set.add(1);
        set.add(2);
        set.add(4);
        set.add(4);
        Iterator<Integer> it = set.iterator();
        while(it.hasNext()) {
            System.out.println(it.next());
        }
        System.out.println(set);

        }

    public static void main1(String[] args) {
        Map<String,String> map = new HashMap<>();
        map.put("mengde","caocao");
        map.put("xiaozhang","zhangfei");
        map.put("xiaoguan","guanyu");
        Set<Map.Entry<String,String>> set = map.entrySet();
        for (Map.Entry<String,String> entry:set) {
            System.out.println(entry.getKey()+ " " + entry.getValue());
        }
    }
}

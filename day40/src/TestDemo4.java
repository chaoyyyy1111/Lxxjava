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

    public static void main5(String[] args) {
        int i=0;
        Integer j = new Integer(0);
        System.out.println(i==j);
        System.out.println(j.equals(i));
        String a = "0.1";
        String b = "1.1";
        System.out.println(a.compareTo(b));
        int[] arr = {1,3,5};


    }
    public static void main4(String[] args) {
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
    public static List<Integer> findClosestElements(int[] arr, int k, int x) {
        Arrays.sort(arr);
        int[][] ret = new int[arr.length][2];
        for (int i = 0; i < ret.length; i++) {
            ret[i][0] = arr[i];
            ret[i][1] = Math.abs(x - arr[i]);
        }
        for (int i = 1; i < ret.length; i++) {
            int tmp = ret[i][1];
            int t = ret[i][0];
            int j = i - 1;
            for (; j >= 0; j--) {
                if (ret[j][1] > tmp) {
                    ret[j+1][0] = ret[j][0];
                    ret[j + 1][1] = ret[j][1];
                } else {
                    break;
                }
            }
            ret[j + 1][0] = t;
            ret[j + 1][1] = tmp;
        }


        List<Integer> list = new ArrayList<>();
        for (int i = 0; i < k; i++) {
            list.add(ret[i][0]);

        }
        return list;
    }

    public static void main(String[] args) {

        String str = "-2147483647";



    }


}

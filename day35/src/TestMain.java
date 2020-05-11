import java.util.*;
import java.util.function.DoubleBinaryOperator;

public class TestMain {
    public static void main1(String[] args) {
        Collection<String> collection = new ArrayList<>();
        collection.add("bit");
        collection.add("java");
        collection.add("lxx");
        System.out.println(collection);
        collection.remove("bit");
        System.out.println(collection);
        System.out.println(collection.size());
        for (String s:collection) {
            System.out.println(s);
        }
        Object[] objects = collection.toArray();
        System.out.println(Arrays.toString(objects));

    }

    public static void main2(String[] args) {
        Map<String,String> map = new HashMap<>();
        map.put("国民老公","王思聪");
        map.put("国民女神","高圆圆");
        map.put("及时雨","宋江");
        System.out.println(map);
        String s = map.get("国民老公");
        String s1 = map.getOrDefault("及时雨2","lxx");
        System.out.println(s);
        System.out.println(s1);
        System.out.println(map.containsKey("及时雨"));
        System.out.println(map.containsValue("高圆圆"));
        Set<Map.Entry<String,String>> set = map.entrySet();
        for (Map.Entry<String,String> m:set) {
            System.out.println(m.getKey() +"->"+m.getValue());
        }
    }

    public static void main(String[] args) {
        int a = 200;
        Integer ii = Integer.valueOf(a);
        Integer ij = new Integer(a);
        Integer ik = Integer.valueOf(a);
        int i = ii.intValue();
        System.out.println(ii == ik);
        Integer b = 10;
        Integer c = 10;
        System.out.println(b == c);
        double num1 = b;
        double num2 = c;
        System.out.println(num1+""+num2);
        
    }

}

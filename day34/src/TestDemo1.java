import java.util.*;

public class TestDemo1 {
    public static void main(String[] args) {
        /*Collection<String> collection = new ArrayList<>();
        collection.add("bit");
        collection.add("lxx");
        collection.add("learn");
        System.out.println(collection);
        System.out.println(collection.isEmpty());
        collection.remove("learn");
        System.out.println(collection);
        System.out.println(collection.size());
        Object[] objects = collection.toArray();
        System.out.println(Arrays.toString(objects));
         */
        Map<String,String> map = new HashMap<>();
        map.put("国民女神","高圆圆");
        map.put("国民老公","王思聪");
        map.put("及时雨","宋江");
        System.out.println(map.get("国民女神"));
        System.out.println(map.getOrDefault("及时雨2", "lxx"));
        System.out.println(map.containsKey("及时雨"));
        System.out.println(map.containsValue("lxx"));
        Set<Map.Entry<String,String>> set = map.entrySet();
        for (Map.Entry<String,String> entry:set) {
            System.out.println(entry.getKey()+ "->" +entry.getValue());
        }

    }

}

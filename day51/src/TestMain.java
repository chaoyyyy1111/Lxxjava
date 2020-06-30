
import java.util.*;
public class TestMain {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        while(scan.hasNext()) {
            int n = scan.nextInt();
            Map<String,Integer> map = new HashMap<>();
            while(n > 0) {
                String c = scan.next();
                map.put(c,0);
                n--;
            }
            map.put("Invalid",0);
            int people = scan.nextInt();
            while(people > 0) {
                String s = scan.next();
                if(map.containsKey(s)) {
                    map.put(s,map.get(s)+1);
                } else {
                    map.put("Invalid",map.get("Invalid")+1);
                }
                people--;
            }
            System.out.println();
            Set<Map.Entry<String, Integer>> entries = map.entrySet();
            for(Map.Entry<String, Integer> entry :entries) {
                System.out.println(entry.getKey()+" "+":"+" "+entry.getValue());
            }
        }
    }
}

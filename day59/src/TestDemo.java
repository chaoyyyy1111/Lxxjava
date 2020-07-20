import java.util.*;

public class TestDemo {
    public static void main(String[] args) {
        Map<Character,Character> map = new HashMap<>();
        map.put('A','2');
        map.put('B','2');
        map.put('C','2');
        map.put('D','3');
        map.put('E','3');
        map.put('F','3');
        map.put('G','4');
        map.put('H','4');
        map.put('I','4');
        map.put('J','5');
        map.put('K','5');
        map.put('L','5');
        map.put('M','6');
        map.put('N','6');
        map.put('O','6');
        map.put('P','7');
        map.put('Q','7');
        map.put('R','7');
        map.put('S','7');
        map.put('T','8');
        map.put('U','8');
        map.put('V','8');
        map.put('W','9');
        map.put('X','9');
        map.put('Y','9');
        map.put('Z','9');
        Scanner scan = new Scanner(System.in);
        while(scan.hasNext()) {
            int n = scan.nextInt();
            Set<String> set = new HashSet<>();
            for (int i = 0; i < n ; i++) {
                String str = scan.next();
                StringBuffer sb = new StringBuffer();
                for (int j = 0; j < str.length(); j++) {
                    char c = str.charAt(j);
                    if(c >= '0' && c <= '9') {
                        sb.append(c);
                    }
                    if(c >= 'A' && c <= 'Z') {
                        sb.append(map.get(c));
                    }
                }
                set.add(sb.toString());
            }

            PriorityQueue<String> pq = new PriorityQueue<>(new Comparator<String>() {
                @Override
                public int compare(String o1, String o2) {
                    return Integer.parseInt(o1)-Integer.parseInt(o2);
                }
            });
            for (String s:set) {
                pq.offer(s);
            }
            while(!pq.isEmpty()) {
                String s = pq.poll();
                String ret = s.substring(0,3)+"-"+s.substring(3);
                System.out.println(ret);
            }
            System.out.println();
        }
    }

}

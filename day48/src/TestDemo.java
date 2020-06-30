import java.util.*;

public class TestDemo {
    public static double func(String str) {
        int count = 0;
        for (int i = 0; i < str.length() ; i++) {
            if(str.charAt(i) == 'G' || str.charAt(i) == 'C') {
                count++;
            }
        }
        return count*1.0/str.length();
    }
    public static void main1(String[] args) {
        Scanner scan = new Scanner(System.in);
        String str = scan.nextLine();
        int n = scan.nextInt();
        List<String> list = new ArrayList<>();
        Map<Double,String> map = new HashMap<>();
        for (int i = 0; i < str.length()-n ; i++) {
            list.add(str.substring(i,i+n));

        }
        double max = func(list.get(0));
        map.put(max,list.get(0));
        for (String s:list) {
            if(func(s) > max) {
                max = func(s);
                map.put(max,s);
            }
        }
        System.out.println(map.get(max));

    }


    public static void main(String[] args) {
        int ret1 = 0;
        int ret2 = 0;
        for (int i = 1; i <= 30 ; i++) {
             ret1 += Math.pow(2,i-1);
             ret2 += 10;
        }
        System.out.println(ret2);
        System.out.println(ret1);
    }
}

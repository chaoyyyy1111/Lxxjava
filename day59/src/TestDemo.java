import java.util.*;
public class TestDemo {
    public static String func(String s) {
        StringBuffer sb = new StringBuffer(s);
        return sb.reverse().toString();
    }
    public static boolean func1(String str,String str1) {
            Map<Character,Integer> map = new HashMap<>();
            for(int i = 0;i < str1.length();i++) {
                if(!map.containsKey(str1.charAt(i))) {
                    map.put(str1.charAt(i),1);
                } else {
                    map.put(str1.charAt(i),map.get(str1.charAt(i))+1);
                }
            }
            for(int i = 0;i < str.length();i++) {
                if((!str1.contains(str.charAt(i)+""))||map.get(str.charAt(i))<1) {
                    char c = str.charAt(i);
                    for(int j = 0; j <= str1.length();j++) {
                        StringBuffer sb = new StringBuffer(str1);
                        if(sb.insert(j,c).toString().equals(func(str))) {
                            //System.out.println("YES");
                            return true;
                        }
                    }
                } else {
                    map.put(str.charAt(i),map.get(str.charAt(i))-1);
                }
            }
            //System.out.println("NO");
            return false;

    }
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        String s = scan.nextLine();
        if(s.length() % 2 == 0) {
            String str = s.substring(0,s.length()/2);
            String str1 = s.substring(s.length()/2+1);
            boolean f1 = func1(str,str1);
            str = s.substring(s.length());
            str1 = s.substring(0,s.length()-1);
            boolean f2 = func1(str,str1);
            if(f1 || f2) {
                System.out.println("YES");
            } else {
                System.out.println("NO");
            }
        } else {
            String str = s.substring(0,s.length()/2+1);
            String str1 = s.substring(s.length()/2+1);
            boolean f1 = func1(str,str1);
            str = s.substring(s.length()/2);
            str1 = s.substring(0,s.length()/2);
            boolean f2 = func1(str,str1);
            if(f1 || f2) {
                System.out.println("YES");
            } else {
                System.out.println("NO");
            }
        }

    }
}
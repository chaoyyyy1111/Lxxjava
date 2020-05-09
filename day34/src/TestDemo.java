import java.util.Arrays;
import java.util.Scanner;

public class TestDemo {
    public static void main1(String[] args) {
        String str = "abcabcabcfffff";
        int index = str.indexOf("abc",4);
        System.out.println(index);
        index = str.lastIndexOf("abc",4);
        System.out.println(index);
        index = str.indexOf("acc");
        System.out.println(index);
        boolean flag = str.startsWith("abc",3);
        System.out.println(flag);
        flag = str.startsWith("abc",9);
        System.out.println(flag);
        flag = str.endsWith("fff");
        System.out.println(flag);
    }

    public static void main2(String[] args) {
        String str = "abc de fg";
        String[] s =str.split(" ");
         for (String string :s ) {
                System.out.println(string);
        }
    }

    public static void main3(String[] args) {
        String str = "192\\168\\1\\1";
        String[] strings = str.split("\\\\");
        for (String s:strings) {
            System.out.println(s);
        }
    }

    public static void main4(String[] args) {
        String str = "Java-split#bit";
        String[] s = str.split( " |-|#");
        for (String string :s ) {
            System.out.println(string);
        }
    }

    public static void main5(String[] args) {
        String str = "name=zhangsan&age=18";
        String[] s = str.split("&");
        for (String strings:s) {
            String[] s1 = strings.split("=");
            for (String string:s1) {
                System.out.println(string);
            }
        }
    }
    public static String func(String str) {
        String[] strings = str.split(" ");
        String ret = "";
        for (String s:strings) {
            ret += s;
        }
        return ret;
    }
    public static void main6(String[] args) {
        Scanner scan = new Scanner(System.in);
        while(scan.hasNext()) {
            String str = scan.nextLine();
            String ret= func(str);
            System.out.println(ret);
        }
    }

    public static void main7(String[] args) {
        String str = "abcdef";
        String str1 = str.toUpperCase();
        System.out.println(str1);
        String s = "";
        boolean flag = s.isEmpty();
        System.out.println(flag);
    }
    public static String reverse(String str) {
        int begin = 0;
        int end = str.length()-1;
        char[] chars = str.toCharArray();
        while(begin < end) {
            char tmp = chars[begin];
            chars[begin] = chars[end];
            chars[end] = tmp;
            begin++;
            end--;
        }
        return new String(chars);
    }
    public static void main8(String[] args) {
        String str = "abcdef";
        String ret = reverse(str);
        System.out.println(ret);
    }

    public static void main(String[] args) {
        /*String str = "";
        for (int i = 0; i < 10 ; i++) {
            str += "a";
        }
        System.out.println(str);
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < 10 ; i++) {
            sb.append("a");
        }
        System.out.println(sb);
         */
        String str = "hello";
        str = str + "world";
        System.out.println(str);
        StringBuilder sb = new StringBuilder("hello");
        sb.append("world");
        System.out.println(sb);
        sb.reverse();
        System.out.println(sb);
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append("a");
        stringBuffer.toString();

    }
}

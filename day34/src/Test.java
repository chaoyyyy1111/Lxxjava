import java.io.UnsupportedEncodingException;
import java.lang.reflect.Field;
import java.util.Arrays;

public class Test {
    public static void main1(String[] args) {
        String str1 = "hello";
        System.out.println(str1);
        String str2 = new String("hello");
        System.out.println(str2);
        char[] val = {'a','b','c','d'};
        String str3 = new String(val);
        System.out.println(str3);
    }
    public static void func(String str1 , char[] val) {
        str1 = "abcd";
        val[0] = 'g';
    }
    public static void main2(String[] args) {
        String str1 = "hello";
        char[] val = {'f'};
        System.out.println(str1);
        System.out.println(Arrays.toString(val));
        func(str1,val);
        System.out.println(str1);
        System.out.println(Arrays.toString(val));
    }

    public static void main3(String[] args) {
        String str1 = "hello";
        String str2 = "hel" + "lo";
        String str3 = (new String("hel")+"lo").intern();
        System.out.println(str1 == str2);
        System.out.println(str2 == str3);
    }

    public static void main4(String[] args) throws NoSuchFieldException, IllegalAccessException {
        String str1 = "hello";
        String str2 = 'H'+ str1.substring(1);
        System.out.println(str1);
        Class c1 = String.class;
        Field field = c1.getDeclaredField("value");
        field.setAccessible(true);
        char[] str = (char[])field.get(str2);
        str[4] = 'h';
        System.out.println(str2);
    }

    public static void main5(String[] args) {
        char[] val = {'a','b','c','d'};
        String str = new String(val,0,4);
        System.out.println(str);
        String str1 = "hello";
        char[] val1 = str1.toCharArray();
        System.out.println(Arrays.toString(val1));
        char a = str1.charAt(1);
        System.out.println(a);
    }
   public static boolean func(String str) {
       for (int i = 0; i < str.length(); i++) {
           char a = str.charAt(i);
           if( a < '0' || a > '9') {
               return false;
           }
       }
       return true;
   }
    public static void main6(String[] args) {
        String str = "123456";
        boolean flag = func(str);
        System.out.println(flag);
    }

    public static void main7(String[] args) throws UnsupportedEncodingException {
        byte[] bytes = {97,98,99,100};
        String str = new String(bytes);
        System.out.println(str);
        String str1 = "林林";
        byte[] be = str1.getBytes("utf8");
        System.out.println(Arrays.toString(be));
    }

    public static int myCompare(String str1,String str2 ) {
        int len1 = str1.length();
        int len2 = str2.length();
        if(len1 != len2) {
            return len1-len2;
        }
        for (int i = 0; i < len1; i++) {
        if(str1.charAt(i) != str2.charAt(i)) {
            return str1.charAt(i) - str2.charAt(i);
        }
        }
        return 0;
    }
    public static void main8(String[] args) {
        String str1 = "abcd";
        String str2 = "abcdef";
        boolean flag = str1.equals(str2);
        System.out.println(flag);
        boolean flag1 = str1.equalsIgnoreCase(str2);
        System.out.println(flag1);
        int a = str1.compareTo(str2);
        System.out.println(a);
        System.out.println(myCompare(str1,str2));
    }

    public static void main(String[] args) {
        String str = "aacd";
        System.out.println(str.replace('a','p'));
        String str1 = "aaaacd";
        System.out.println( str1.replace("aa","pp"));
        System.out.println(str1.substring(0,3));
        String str2 = "    abc     ";
        System.out.println(str2.trim());
        System.out.println(str1.replaceFirst("aa","pp"));
    }
}

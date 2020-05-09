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

    public static int myCompare1(String str1,String str2 ) {
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

    public static void main9(String[] args) {
        String str = "aacd";
        System.out.println(str.replace('a','p'));
        String str1 = "aaaacd";
        System.out.println( str1.replace("aa","pp"));
        System.out.println(str1.substring(0,3));
        String str2 = "    abc     ";
        System.out.println(str2.trim());
        System.out.println(str1.replaceFirst("aa","pp"));
    }
    public static String reverse(String str,int begin,int end) {
        char[] chars = str.toCharArray();
        while(begin < end) {
            char tmp = chars[begin];
            chars[begin] = chars[end];
            chars[end] = tmp;
            begin++;
            end--;
        }
        String s = new String(chars);
        return s;
    }
    public static String func(String str,int n) {
        String str1 = reverse(str,0,n-1);
        String str2 = reverse(str1,n,str.length()-1);
        String str3 = reverse(str2,0,str.length()-1);
    return str3;
    }
    public static void main10(String[] args) {
        String str = "abcdefg";
        String ret = func(str,3);
        System.out.println(ret);
    }

    public static String myReplace(String str,String s,String b) {
        String[] strings = str.split(s);
        StringBuffer ret = new StringBuffer("");
        for (int i = 0; i < strings.length-1; i++) {
            ret.append(strings[i]).append(b);
        }
        ret.append(strings[strings.length-1]);
        return ret.toString();
    }
    public static int myIndexOf(String str,String s,int k) {
        int len = s.length();
        if(len > str.length()) {
            return -1;
        }
        for (int i = k; i < str.length()-len+1; i++) {
            if(s.equals(str.substring(i,i+len))) {
                return i;
            }
        }
        return -1;
    }
    public static boolean myContains(String str,String s) {
        int len = s.length();
        if(len > str.length()) {
            return false;
        }
        for (int i = 0; i < str.length()-len+1; i++) {
            if(s.equals(str.substring(i,i+len))) {
                return true;
            }
        }
        return false;
    }
    public static int myCompare(String str1,String str2) {
        if(str1.length() != str2.length()) {
            return str1.length() - str2.length();
        }
        for (int i = 0; i < str1.length() ; i++) {
            if(str1.charAt(i) != str2.charAt(i)) {
                return str1.charAt(i) - str2.charAt(i);
            }
        }
        return 0;
    }
    public static String[] mySplit(String str,String s) {
        int[] index = new int[str.length()];
        index[0] = -1;
        int len =s.length();
        String[] string = {str};
        if(len > str.length()) {
            return string;
        }
        int count = 1;
        if(len == 1) {
            for (int i = 0; i < str.length()-len+1; i++) {
                if(s.equals(str.substring(i,i+len))) {
                    index[count] = i;
                    count++;
                }
            }
        } else {
            for (int i = 0; i < str.length()-len+1; i++) {
                if(s.equals(str.substring(i,i+len))) {
                    index[count] = i;
                    count++;
                    index[count] = i+len-1;
                    count++;

                }
            }
        }
        if(count == 1) {
            return string;
        }

        if(len == 1) {
            int j = 0;
            String[] ret = new String[count];
            for (int i = 0; i < count -1 ; i++) {
                ret[j] = str.substring(index[i]+1,index[i+1]);
                j++;
            }
            ret[j] = str.substring(index[count-1]+1);
            return ret;
        } else {
            int j = 1;
            String[] ret = new String[count/2+1];
            for (int i = 2; i < count -1  ; i += 2) {
                ret[0] = str.substring(0,index[1]);
                ret[j] = str.substring(index[i]+1,index[i+1]);
                j++;
            }
            ret[j] = str.substring(index[count-1]+1);
            if(ret[j].equals("")) {
                ret = Arrays.copyOfRange(ret,0,j);
            }

            return ret;
        }
    }
    public static void main(String[] args) {
        String str= "abcefeabc";
        str.split("efe");
        System.out.println(Arrays.toString(str.split("efe")));
        System.out.println(Arrays.toString(mySplit(str,"efe")));
    }

}

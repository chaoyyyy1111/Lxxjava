import java.util.*;

public class TestDemo {
    static String[] ret =  {"0","1"};
    public static String[] getGray(int n) {
        // write code here
        if(n == 1) {
            return ret;
        }
        String[] tmp = new String[2*ret.length];
        int j = 0;
        for (int i = 0; i < ret.length ; i++) {
            tmp[j] = "0" + ret[i];
            tmp[tmp.length - 1 - j] = "1" + ret[i];
            j++;
        }
        ret = tmp;
        getGray(n-1);
        return ret;
    }

    public static void main(String[] args) {
        String[] strs = getGray(3);
        System.out.println(Arrays.toString(strs));
    }
}



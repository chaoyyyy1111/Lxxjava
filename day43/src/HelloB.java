import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class HelloB  {
    public static void main1(String[] args) {
        Scanner scan = new Scanner(System.in);
        String str = scan.nextLine();
        String[] strs = str.split(" ");
        int[] array = new int[strs.length];
        for (int i = 0; i < strs.length ; i++) {
            array[i] = Integer.parseInt(strs[i]);
        }
        int a = 0;
        int b = 0;
        int c = 0;
        if((array[0] + array[2]) % 2 != 0 || (array[1] + array[3]) % 2 != 0){
            System.out.println("No");
        } else {
            a = (array[0] + array[2])/2;
            b = (array[1] + array[3])/2;
            c = array[3] - b;
        }
        if(a < 0 || b < 0 || c < 0) {
            System.out.println("No");
        } else {
            System.out.println(a+" "+b+" "+c);
        }
    }

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        String str = scan.nextLine();
        String[] strs = str.split(" ");
        Map<String,Integer> map = new HashMap<>();
        for (int i = 0; i < strs.length ; i++) {
            if(!map.containsKey(strs[i])) {
                map.put(strs[i],1);
            } else {
                map.put(strs[i],map.get(strs[i])+1);
            }
        }
        for (int i = 0; i < strs.length ; i++) {
            if(map.get(strs[i]) >= strs.length/2) {
                System.out.println(strs[i]);
                break;
            }
        }
    }
}

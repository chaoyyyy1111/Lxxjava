import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class TestMain {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        List<Integer> list = new ArrayList<>();
        while(scan.hasNext()) {
            String str1 = scan.nextLine();
            int n = Integer.parseInt(str1);
            if(n == 0) {
                break;
            }
            String str2 = scan.nextLine();
            String[] strs = str2.split(" ");
            String str3 = scan.nextLine();
            int count = 0;
            for (int i = 0; i < strs.length ; i++) {
                if(strs[i].equals(str3)) {
                    count++;
                }
            }
            list.add(count);
        }
        for (Integer i:list) {
            System.out.println(i);
        }
    }
}

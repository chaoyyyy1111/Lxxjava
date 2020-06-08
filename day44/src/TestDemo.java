import java.util.Scanner;

public class TestDemo {
    public static void main1(String[] args) {
       Scanner scan = new Scanner(System.in);
       String str = scan.nextLine();
       String[] strs = str.split(" ");
       int W = Integer.parseInt(strs[0]);
       int H = Integer.parseInt(strs[1]);
       if(W - 1 >= 2 && H - 1 < 2) {
           System.out.println(W*H-H*(W/2));
       } else if(W - 1 < 2 && H - 1 >= 2) {
           System.out.println(W*H-W*(H/2));
       } else {
           System.out.println(W*H-W*(H/2)-H*(W/2)+2*(W/2)*(H/2));
       }
    }

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        String str = scan.nextLine();
        String[] strs = str.split(" ");
        int num1 = Integer.parseInt(strs[0]);
        int num2 = Integer.parseInt(strs[1]);
        if(num1 > num2) {
            int tmp = num1;
            num1 = num2;
            num2 = tmp;
        }
        if(num2 % num1 == 0) {
            System.out.println(num2);
        } else {
            int tmp = num2;
            while(num2 % num1 != 0) {
                num2 += tmp;
            }
            System.out.println(num2);
        }
    }
}

import java.util.Scanner;

public class TestMain1 {
    public static void func(int[][] nums) {
        for (int i = 0; i < nums.length-1; i++) {
            for(int k = 0; k < nums.length-1-i ;k++) {
                if(nums[k].length > nums[k+1].length) {
                    int[] tmp = nums[k];
                    nums[k] = nums[k+1];
                    nums[k+1] = tmp;
                } else if(nums[k].length == nums[k+1].length) {
                    for (int j = 0; j < nums[i].length ; j++) {
                        if(nums[k][j] > nums[k+1][j]) {
                            int[] tmp = nums[k];
                            nums[k] = nums[k+1];
                            nums[k+1] = tmp;
                            break;
                        } else if(nums[k][j] < nums[k+1][j]) {
                            break;
                        }
                    }
                }
            }
        }
    }
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int n = scan.nextInt();
        int[][] nums = new int[n][];
        for (int i = 0; i < nums.length; i++) {
            String s = scan.next();
            String[] str = s.split("");
            nums[i] = new int[str.length];
            for (int j = 0; j < str.length; j++) {
                nums[i][j] = Integer.parseInt(str[j]);
            }
        }
        func(nums);
        for (int i = 0; i < nums.length ; i++) {
            for (int j = 0; j < nums[i].length ; j++) {
                System.out.print(nums[i][j]);
            }
            System.out.println();
        }
    }
}

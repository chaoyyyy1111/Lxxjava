import java.util.Scanner;

public class TestDemo {
    public static int countWays(int x, int y) {
        // write code here
        if(x == 1 || y == 1) {
            return 1;
        }
        return countWays(x-1,y) + countWays(x,y-1);
    }

    public static void main(String[] args) {
        System.out.println(countWays(3, 3));

    }
}



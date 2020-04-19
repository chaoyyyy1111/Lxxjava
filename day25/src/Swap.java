public class Swap {
 static int num1;
 static int num2;

    /*public Swap() {
    }
    public Swap(int num1, int num2) {
        Swap.num1 = num1;
        Swap.num2 = num2;
    }
     */
    public static void exchange() {
        int tmp = Swap.num1;
        Swap.num1 = Swap.num2;
        Swap.num2 = tmp;
    }

    public static void main(String[] args) {
        num1 = 3;
        num2 = 4;
        exchange();
        System.out.println(num1+" "+num2);

    }

}

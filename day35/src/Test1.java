import java.util.Scanner;

public class Test1 {
    public static void main1(String[] args) {
        MyArrayList<String> myArrayList = new MyArrayList<>();
        myArrayList.add("hello");
        myArrayList.add("world");
        System.out.println(myArrayList.get(0));
        System.out.println(myArrayList);
        MyArrayList myArrayList1 = new MyArrayList();
        myArrayList1.add("hello");
        myArrayList1.add(1);
        int a = (int)myArrayList1.get(1);
    }

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        String str = scan.nextLine();
        StringBuffer sb = new StringBuffer();
        for (int i = 0; i < str.length() ; i++) {
            char ch = str.charAt(i);
            String tmp = sb.toString();
            if(! tmp.contains(ch+"")) {
                sb.append(ch);
            }
        }
        System.out.println(sb);
    }

}

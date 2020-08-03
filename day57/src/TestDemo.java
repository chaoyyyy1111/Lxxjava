import java.util.*;
class Customer {
    public int person;
    public int money;
    public Customer(int person,int money) {
        this.person = person;
        this.money  = money;
    }
}
class CSort implements Comparator<Customer>{
    @Override
    public int compare(Customer o1, Customer o2) {
        return o2.money-o1.money;
    }

}
public class TestDemo {


    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int table = scan.nextInt();
        int n = scan.nextInt();
        int[] tmp = new int[table];
        Customer[] customers = new Customer[n];
        for(int i = 0;i < table;i++) {
            tmp[i] = scan.nextInt();
        }
        for (int i = 0; i < n ; i++) {
            Customer c = new Customer(scan.nextInt(),scan.nextInt());
            customers[i] = c;
        }
        CSort cSort = new CSort();
        Arrays.sort(customers,cSort);
        Arrays.sort(tmp);
        List<Integer> list = new ArrayList<>();
        for (int i = 0; i < tmp.length ; i++) {
            list.add(tmp[i]);
        }
        int sum = 0;
        for (int i = 0; i < customers.length  ; i++) {
            for (int j = 0; j < list.size() ; j++) {
                if(customers[i].person <= list.get(j)) {
                    sum += customers[i].money;
                    list.remove(j);
                    break;
                }
            }
        }
        System.out.println(sum);
    }
}

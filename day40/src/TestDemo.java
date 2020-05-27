import java.util.Arrays;

class Money implements Cloneable {
    protected int money = 2;

    @Override
    public String toString() {
        return "Money{" +
                "money=" + money +
                '}';
    }

    @Override
    protected Object clone() throws CloneNotSupportedException {
        return super.clone();
    }
}
class Person implements Cloneable{
    protected int age;
    protected Money m;
    public Person(int age) {
        this.age = age;
        m = new Money();
    }

    @Override
    public String toString() {
        return "Person{" +
                "age=" + age +
                ", m=" + m +
                '}';
    }

    @Override
    protected Object clone() throws CloneNotSupportedException {
        Person p = (Person)super.clone();
        p.m = (Money)this.m.clone();
        return p;
    }
}
public class TestDemo {
    public static void main1(String[] args) {
        Person person1 = new Person(12);
        try {
            Person person2 = (Person)person1.clone();
            person2.age = 10;
            person2.m.money = 100;
            System.out.println(person1);
            System.out.println(person2);
        } catch (CloneNotSupportedException e) {
            e.printStackTrace();
        }

    }
    public static void swap(int[] array) {
        int tmp = array[0];
        array[0] = array[1];
        array[1] = tmp;
    }
    public static void main2(String[] args) {
        int[] array = {10,20};
        System.out.println(Arrays.toString(array));
        swap(array);
        System.out.println(Arrays.toString(array));
    }

    public static void main(String[] args) {
        int[][] array = new int[2][];
        array[0] = new int[]{1,2,3};
        array[1] = new int[]{4,5};
        System.out.println(Arrays.deepToString(array));
    }

}

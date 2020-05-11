import java.util.Scanner;

class Money implements Cloneable {
    protected int m = 5;
    @Override
    protected Object clone() throws CloneNotSupportedException {
        return super.clone();
    }
}
class Person implements Cloneable{
    protected int age = 12;
    protected Money money = new Money();
    @Override
    protected Object clone() throws CloneNotSupportedException {
               Person p = (Person)super.clone();
               p.money = (Money)this.money.clone();
               return p;
    }
}
public class TestDemo {
    public static void main(String[] args) {
        int[] array = {1,2,3};
        try {
            System.out.println(array[4]);
            System.out.println("xixi");
        } catch(ArrayIndexOutOfBoundsException e) {
            e.printStackTrace();
            System.out.println("数组越界异常");
        } catch(Exception e) {
            e.printStackTrace();
            System.out.println("异常");
        } finally {
            System.out.println("hello");
        }
        System.out.println("haha");
    }

    public static void main2(String[] args) {
        Scanner scan = new Scanner(System.in);
        int num = scan.nextInt();
        try {
            System.out.println(10/num);
        } catch(ArithmeticException e) {
            e.printStackTrace();
            System.out.println("算数异常");
        } finally {
            scan.close();
        }
    }

    public static void func() {
        int[] array = {1,2,3,4};
        System.out.println(array[100]);
    }
    public static void main3(String[] args) {
        try {
            func();
        } catch(ArrayIndexOutOfBoundsException e) {
            e.printStackTrace();
            System.out.println("数组越界异常");
        }
    }

    public static void divide(int num1,int num2) throws ArithmeticException {
        if(num2 == 0) {
            throw new ArithmeticException("num2 = 0");
        }
        System.out.println(num1/num2);
    }
    public static void main4(String[] args) {
        try {
            divide(1,0);
        } catch (ArithmeticException e) {
            e.printStackTrace();
            System.out.println("算数异常");
        }
        System.out.println("继续执行");

    }

    public static void main5(String[] args) {
        Person person = new Person();
        try {
            Person person1 = (Person)person.clone();
            System.out.println(person.age);
            System.out.println(person.money.m);
            System.out.println(person1.age);
            System.out.println(person1.money.m);
            person.money.m = 3;
            person.age = 20;
            System.out.println(person.age);
            System.out.println(person.money.m);
            System.out.println(person1.age);
            System.out.println(person1.money.m);
        } catch (CloneNotSupportedException e) {
            e.printStackTrace();

        }
    }
    public static void func(int x) throws MyException {
        if(x == 10) {
            throw new MyException("x = 10");
        }
    }
    public static void main6(String[] args) {
        try {
            func(10);
        } catch (MyException e) {
            e.printStackTrace();
        }
    }

}

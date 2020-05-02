class Money implements Cloneable{
    double money = 12.5;

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
class Person implements Cloneable {
    int age = 12;
    Money m = new Money();

    @Override
    protected Object clone() throws CloneNotSupportedException {
        Person p =(Person)super.clone();
        p.m=(Money)this.m.clone();
        return p;
    }

    @Override
    public String toString() {
        return "Person{" +
                "age=" + age +
                ", m=" + m +
                '}';
    }
}
public class Test {
    public static void main(String[] args) {
        Person person1 = new Person();
        Person person2 = new Person();
        person2.age = 18;
        person2.m.money = 100;
        System.out.println(person1);
        System.out.println(person2);

    }

}

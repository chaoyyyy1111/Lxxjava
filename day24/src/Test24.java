
public class Test24 {
    public static void main(String[] args) {
        Person person = new Person();
        System.out.println(person.getName());
        System.out.println(person.getAge());
        Person person1 = new Person("王五",22);
        System.out.println(person1);
        System.out.println(Person.getCount());
        /*new Person("张飞",18);
        System.out.println(new Person("曹操",20));
         */
    }


}

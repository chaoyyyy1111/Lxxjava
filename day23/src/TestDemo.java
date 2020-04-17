public class TestDemo {
    public static void main1(String[] args) {
    Person person = new Person();
    person.setName("Lily");
    person.setAge(12);
    person.setSex('女');
    System.out.println(person);
    person.sleep();
    Person.eat();
    person.day();
    Person.setSize(88);
        System.out.println(Person.getSize());

    }

    public static void main(String[] args) {
        Student student = new Student();
        student.name = "王五";
        student.age = 18;
        student.id = "1324323";
        student.avgScore = 92;
        Student.course();
        System.out.println(student);
    }
}

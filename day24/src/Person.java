public class Person {
    private String name;
    private int age;
    private static int count = 0;
    static {
        System.out.println("static");
        count = 1;
    }
    {
        this.name ="张飞";
        this.age = 18;
        System.out.println("妲己");
        count = 2;
    }
    public Person() {
        this("妹喜",17);
    }
    public Person(String name, int age) {
        this.name = name;
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }
    public static int getCount() {
        return count;
    }

    public static void setCount(int count) {
        Person.count = count;
    }

    @Override
    public String toString() {
        return "Person{" +
                "name='" + name + '\'' +
                ", age=" + age +
                '}';
    }
}

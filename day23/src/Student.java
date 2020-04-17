public class Student {
    public String name;
    public int age;
    public static final String grade = "8班";
    public String id;
    public int avgScore;

    public static void course() {
        System.out.println(Student.grade+" "+ "语文 数学 英语 物理");
    }

    @Override
    public String toString() {
        return "Student{" +
                "grade=" + Student.grade +
                ", name='" + this.name + '\'' +
                ", age=" + this.age +
                ", id='" + this.id + '\'' +
                ", avgScore=" + this.avgScore +
                '}';
    }



}

import java.util.Arrays;

class Student implements Comparable<Student>{
    public String name;
    public int age;
    public int score;
    public Student(String name,int age,int score) {
        this.name = name;
        this.age = age;
        this.score = score;
    }

    @Override
    public int compareTo(Student o) {
        return this.score - o.score;
    }

    @Override
    public String toString() {
        return "Student{" +
                "name='" + name + '\'' +
                ", age=" + age +
                ", score=" + score +
                '}';
    }
}
public class TestDemo1 {
    public static void main(String[] args) {
        Student student1 = new Student("lxx",18,98);
        Student student2 = new Student("wangjia",19,90);
        Student student3 = new Student("lilin",11,50);
        Student[] students = {student1,student2,student3};
        Arrays.sort(students);
        System.out.println(Arrays.toString(students));
        System.out.println(student1.compareTo(student2));
    }
}

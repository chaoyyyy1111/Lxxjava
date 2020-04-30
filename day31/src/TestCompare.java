import java.util.Arrays;

class Student implements Comparable<Student>{
    public String name;
    public int age;
    public int score;

    public Student(String name, int age, int score) {
        this.name = name;
        this.age = age;
        this.score = score;
    }

    @Override
    public String toString() {
        return "Student{" +
                "name='" + name + '\'' +
                ", age=" + age +
                ", score=" + score +
                '}';
    }

    @Override
    public int compareTo(Student o) {
        if(this.age > o.age) {
            return 1;
        } else if(this.age < o.age) {
            return -1;
        } else {
            return 0;
        }
    }
}

public class TestCompare {
    public static void main(String[] args) {
        Student student1 = new Student("lily",17,90);
        Student student2 = new Student("bian",18,80);
        Student student3 = new Student("chenchen",20,97);
        if(student1.compareTo(student2) < 0 ) {
            System.out.println("student1的年龄比较小");
        }
        Student[] students ={student1,student2,student3};
        Arrays.sort(students);
        System.out.println(student1);
        System.out.println(Arrays.toString(students));


    }

}

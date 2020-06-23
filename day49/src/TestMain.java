import java.util.Arrays;
import java.util.Comparator;
import java.util.Scanner;

class Student {
    String name;
    int score;
    int index;
    public Student(String name,int score,int index) {
        this.name = name;
        this.score = score;
        this.index = index;
    }
}
class Asc implements Comparator<Student> {
    @Override
    public int compare(Student o1, Student o2) {
        if(o1.score != o2.score) {
            return o1.score - o2.score;
        } else {
            return o1.index - o2.index;
        }
    }
}

class Desc implements Comparator<Student> {
    @Override
    public int compare(Student o1, Student o2) {
        if(o1.score != o2.score) {
            return o2.score - o1.score;
        } else {
            return o1.index - o2.index;
        }
    }
}
public class TestMain {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int n = scan.nextInt();
        int ascOrDesc = scan.nextInt();
        Student[] students = new Student[n];
        int i = 0;
        while(n > 0) {
            String name = scan.next();
            int score = scan.nextInt();
            students[i++] = new Student(name,score,i);
            n--;
        }
        if(ascOrDesc == 0) {
            Arrays.sort(students,new Desc());
        } else {
            Arrays.sort(students,new Asc());
        }
        for (int j = 0; j < students.length ; j++) {
            System.out.println(students[j].name+" "+students[j].score);
        }
    }
}

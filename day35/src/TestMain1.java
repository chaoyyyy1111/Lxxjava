import java.util.*;

class Student {
    public String name;
    public String grade;
    public double score;

    @Override
    public String toString() {
        return "Student{" +
                "name='" + name + '\'' +
                ", grade='" + grade + '\'' +
                ", score=" + score +
                '}';
    }

    public Student(String name, String grade, double score) {
        this.name = name;
        this.grade = grade;
        this.score = score;

    }
}
public class TestMain1 {
    public static void main1(String[] args) {
        Student student1 = new Student("张三","12班",98);
        Student student2 = new Student("王五","12班",97);
        Student student3 = new Student("李四","12班",96);
        List<Student> list = new ArrayList<>();
        list.add(student1);
        list.add(student2);
        list.add(student3);
        System.out.println(list);
    }

    public static void main2(String[] args) {
        List<Integer> list = new ArrayList<>();
        list.add(7);
        list.add(2);
        list.add(10);
        Collections.sort(list);
        System.out.println(list);
    }
    public static List<Character> func(String str1,String str2) {
        List<Character> list = new ArrayList<>();
        for (int i = 0; i < str1.length() ; i++) {
            char ch = str1.charAt(i);
            if(!str2.contains(ch+"")) {
                list.add(ch);
            }
        }
        return list;
    }
    public static void main3(String[] args) {
        String str1 = "welcome to bit";
        String str2 = "come";
        System.out.println(func(str1, str2));
    }

    public static List<List<Integer>> func(int numRows) {
        List<List<Integer>> ret = new ArrayList<>();
        if(numRows == 0) {
            return ret;
        }
        ret.add(new ArrayList<>());
        ret.get(0).add(1);
        for (int i = 1; i < numRows; i++) {
            ret.add(new ArrayList<>());
            ret.get(i).add(1);
            List<Integer> preRows = ret.get(i-1);
            for (int j = 1; j < i ; j++) {
                int x = preRows.get(j);
                int y = preRows.get(j-1);
                ret.get(i).add(x + y);
            }
            ret.get(i).add(1);
        }
        return ret;
    }
    public static void main(String[] args) {
        System.out.println(func(4));
    }
}

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
class Student {
     private String name;
     private String classes;
     private int score;

     public Student(String name, String classes, int score) {
          this.name = name;
          this.classes = classes;
          this.score = score;
     }

     public String getName() {
          return name;
     }

     public void setName(String name) {
          this.name = name;
     }

     public String getClasses() {
          return classes;
     }

     public void setClasses(String classes) {
          this.classes = classes;
     }

     public int getScore() {
          return score;
     }

     public void setScore(int score) {
          this.score = score;
     }

     @Override
     public String toString() {
          return "Student{" +
                  "name='" + name + '\'' +
                  ", classes='" + classes + '\'' +
                  ", score=" + score +
                  '}';
     }
}
public class Test {
     public static List<List<Integer>> generate(int numRows) {
          List<List<Integer>> list = new ArrayList<>();
          if(numRows == 0) {
               return list;
          }
          List<Integer> oneRow = new ArrayList<>();
          list.add(oneRow);
          list.get(0).add(1);
          for (int i = 1; i < numRows ; i++) {
               List<Integer> curRow = new ArrayList<>();
               curRow.add(1);
               List<Integer> prevRow = list.get(i-1);
               for (int j = 1; j < i; j++) {
                    int x = prevRow.get(j);
                    int y = prevRow.get(j-1);
                    curRow.add(x+y);
               }
               curRow.add(1);
               list.add(curRow);
          }
          return list;
     }

     public static void main1(String[] args) {
          List<List<Integer>> list = generate(4);
          System.out.println(list);
     }

     public static void main2(String[] args) {
          Student student1 = new Student("王五","12班",98);
          Student student2 = new Student("李四","13班",97);
          List<Student> list = new ArrayList<>();
          list.add(student1);
          list.add(student2);
          System.out.println(list);
     }

     public static void main3(String[] args) {
          List<Integer> list = new ArrayList<>();
          list.add(7);
          list.add(1);
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
     public static void main4(String[] args) {
          String str1 = "welcome to bit";
          String str2 = "come";
          List<Character> list = func(str1,str2);
          for (int i = 0; i < list.size(); i++) {
               System.out.print(list.get(i));
          }
          System.out.println();
     }

     public static void main(String[] args) {
          List<String> list = new ArrayList<>();
          list.add("hello");
          list.add(1,"lxx");
          System.out.println(list);
          List<String> list1 = new ArrayList<>();
          list1.add("play");
          list1.add("fun");
          list1.addAll(list);
          System.out.println(list1);
          list1.remove(0);
          System.out.println(list1);
          list1.set(2,"xixi");
          System.out.println(list1);
          System.out.println(list1.indexOf("xixi"));
          List<String> list2 = new ArrayList<>();
          list2 = list1.subList(1,3);
          System.out.println(list2);
     }
}

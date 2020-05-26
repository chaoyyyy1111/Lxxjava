import java.util.Arrays;
import java.util.PriorityQueue;

class Person {
    public String name;
    public int age;
    public int score;
    public Person(String name, int age, int score) {
        this.name = name;
        this.age = age;
        this.score = score;
    }

     @Override
     public String toString() {
         return "Person{" +
                 "name='" + name + '\'' +
                 ", age=" + age +
                 ", score=" + score +
                 '}';
     }
 }
public class TestDemo2 {
    public static void main(String[] args) {
        /*Person person1 = new Person("lxx",18,98);
        Person person2 = new Person("wangjia",19,90);
        Person person3 = new Person("lilin",11,50);
        Person[] people = {person1,person2,person3};
        AgeComparator ageComparator = new AgeComparator();
        Arrays.sort(people,ageComparator);
        System.out.println(Arrays.toString(people));
        System.out.println(ageComparator.compare(person1, person2));
        ScoreComparator scoreComparator = new ScoreComparator();
        System.out.println(scoreComparator.compare(person1, person2));
         */
        AgeComparator ageComparator = new AgeComparator();
        PriorityQueue<Person> pq = new PriorityQueue<>(ageComparator);
        pq.offer(new Person("lxx",12,100));
        pq.offer(new Person("coco",18,99));
        System.out.println(pq);
    }
}
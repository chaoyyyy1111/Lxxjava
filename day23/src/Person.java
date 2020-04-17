public class Person {
 private String name;
 private int age;
 private char sex;
 private static int size;
 public static void eat() {
  System.out.println("eat");
 }
 public void sleep() {
  System.out.println("sleep");
 }
 public void day() {
  eat();
  sleep();
 }
 public void setName(String name) {
  this.name = name;
 }

 public void setAge(int age) {
  this.age = age;
 }

 public void setSex(char sex) {
  this.sex = sex;
 }

 public static void setSize(int size) {
  Person.size = size;
 }

 public String getName() {
  return this.name;
 }

 public int getAge() {
  return this.age;
 }

 public char getSex() {
  return this.sex;
 }

 public static int getSize() {
  return Person.size;
 }

 @Override
 public String toString() {
  return "Person{" +
          "name='" + this.name + '\'' +
          ", age=" + this.age +
          ", sex=" + this.sex +
          '}';
 }
}

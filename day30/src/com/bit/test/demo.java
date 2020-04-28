package com.bit.test;

 class Animal {
    public String name;

    public Animal(String name) {
        this.name = name;

    }

    public void eat() {
        System.out.println("Animal"+" "+this.name+" "+"eat");
    }

}
class Cat extends Animal {
    public Cat(String name) {
        super(name);
    }
    public void eat() {
        System.out.println("Cat"+ " "+this.name+" "+"eat");
    }
    public void sleep() {
        System.out.println("sleep");
    }
}
class Bird extends Animal {
    public Bird(String name) {
        super(name);
    }
    public void fly() {
        System.out.println("fly");
    }
}
public class demo {
    public static void func1(Animal animal) {
        animal.eat();
    }
    public static Animal func2() {
        return new Cat("baobao");
    }
    public static void main(String[] args) {
        Animal animal = new Cat("chaichai");
        animal.eat();
        /*Cat cat = new Cat("mimi");
        func1(cat);
        Animal animal = func2();
        animal.eat();
        Animal animal1 = new Cat("diaodiao");
        /*Animal animal = new Cat("mimi");
        animal.eat();
        Cat cat = (Cat)animal;
        cat.sleep();
        if(animal instanceof Bird) {
            Bird bird = (Bird)animal;
            bird.fly();
         */
        }

    }



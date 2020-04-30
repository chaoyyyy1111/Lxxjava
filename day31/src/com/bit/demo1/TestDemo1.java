package com.bit.demo1;

abstract class Shape {
    public abstract void draw();
}
class Cycle extends Shape {
    @Override
    public void draw() {
        System.out.println("画一个圆");
    }
}
class Flower extends Shape{
    @Override
    public void draw() {
        System.out.println("画一朵花");
    }
}
class React extends Shape {
    @Override
    public void draw() {
        System.out.println("画一个方块");
    }
}
public class TestDemo1 {
    public static void func(Shape shape) {
        shape.draw();
    }
    public static void main1(String[] args) {
        Shape[] shapes = {new Cycle(),new Flower(),new React()};
        for (Shape shape:shapes) {
            shape.draw();
        }
    }
    public static void main2(String[] args) {
        Shape shape1 = new Cycle();
        Shape shape2 = new React();
        Shape shape3 = new Flower();
        func(shape1);
        func(shape2);
        func(shape3);
    }
    public static void main(String[] args) {
        Flower flower = new Flower();
        React react = new React();
        Cycle cycle = new Cycle();
        String[] str = {"flower","react","cycle"};
        for (String string:str) {
            if(string.equals("cycle")) {
                cycle.draw();
            }else if(string.equals("flower")) {
                flower.draw();
            }else {
                react.draw();
            }
        }
    }

}

class Animal {
    protected String name;
    public Animal(String name) {
        this.name = name;
    }
}
interface ISwimming {
    void swim();
}
interface IRunning {
    void run();
}
class Cat extends Animal implements IRunning {
    public Cat(String name) {
        super(name);
    }

    @Override
    public void run() {
        System.out.println(this.name+"猫在跑步");
    }
}
class Fish extends Animal implements ISwimming {
    public Fish(String name) {
        super(name);
    }

    @Override
    public void swim() {
        System.out.println(this.name+"鱼在游泳");
    }
}
class Frog extends Animal implements IRunning,ISwimming {
    public Frog(String name) {
        super(name);
    }

    @Override
    public void swim() {
        System.out.println(this.name+"青蛙在游泳");
    }

    @Override
    public void run() {
        System.out.println(this.name+"青蛙在跑步");
    }
}
public class TestInterFace {
    public static void main1(String[] args) {
        IRunning[] iRunning = {new Cat("mimi"),new Frog("qingqing")};
        ISwimming[] iSwimming = {new Fish("weiwei"),new Frog("qingqing")};
        for (IRunning iRunnings:iRunning) {
            iRunnings.run();
        }
        for (ISwimming iSwimmings: iSwimming) {
            iSwimmings.swim();
        }
    }

    public static void swim(ISwimming iSwimming) {
        iSwimming.swim();
    }
    public static void run(IRunning iRunning) {
        iRunning.run();
    }
    public static void main(String[] args) {
        Cat cat = new Cat("mimi");
        run(cat);
        Fish fish = new Fish("weiwei");
        swim(fish);
        Frog frog = new Frog("qingqing");
        run(frog);
        swim(frog);
    }
}
class Animal {
public void func() {
    System.out.println("汪汪汪");
}
}
public class TestDemo4 {
    public static void main(String[] args) {
        new Animal() {
            public void func() {
                System.out.println("lalalala");
            }
        }.func();
    }
}

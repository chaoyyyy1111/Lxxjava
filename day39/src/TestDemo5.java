class OuterClass {
    public int data1 = 1;
    public int data2 = 2;
    public int data3 = 3;
    public void func() {
        System.out.println("outerclass");
    }
    class InnerClass {
        public int data1 = 11;
        public int data4 = 4;
        public int data5 = 5;
        public void func() {
            System.out.println("lalalalala");
            System.out.println(data1);
            System.out.println(OuterClass.this.data1);
            System.out.println(data2);
            System.out.println(data3);
            System.out.println(data4);
        }
    }
}
public class TestDemo5 {
    public static void main(String[] args) {
        OuterClass outerClass = new OuterClass();
        OuterClass.InnerClass innerClass = outerClass.new InnerClass();
        innerClass.func();
    }
}

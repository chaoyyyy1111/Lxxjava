class OuterClass {
    public int data1 = 1;
    public int data2 = 2;
    public int data3 = 3;
    static class InnerClass {
        public int data1 = 11;
        public int data4 = 4;
        public int data5 = 5;
        public OuterClass out;
        public InnerClass(OuterClass out) {
            this.out = out;
        }
        public void func() {
            System.out.println(this.out.data1);
            System.out.println(data1);
            System.out.println(data4);
            System.out.println(data5);

        }
    }
}
public class TestDemo1 {
    public static void main(String[] args) {
        OuterClass out = new OuterClass();
        OuterClass.InnerClass innerClass = new OuterClass.InnerClass(out);
        innerClass.func();
    }
}

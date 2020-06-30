


public class TestMain  {
    private int count;


    public static void main(String[] args) {
        TestMain t = new TestMain(88);
        System.out.println(t.count);
    }
    public TestMain(int a) {
        count = a;
    }
}

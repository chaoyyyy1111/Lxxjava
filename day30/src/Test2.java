import com.bit.test.Animal1;



public class Test2 extends Animal1 {
    public Test2(String name) {
        super(name);
    }
    public void func() {
        Animal1 animal1 = new Animal1("didi");
        System.out.println(super.name);
    }
    public static void main(String[] args) {

        Test2 test2 = new Test2("wangwang");
        System.out.println(test2.name);

    }
}

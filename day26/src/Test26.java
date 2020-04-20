

class MyValue {
    private int num1;

    public int getNum1() {
        return num1;
    }

    public void setNum1(int num1) {
        this.num1 = num1;
    }
}
class Calculator{
    private int num1;
    private int num2;

    public int getNum1() {
        return num1;
    }

    public void setNum1(int num1) {
        this.num1 = num1;
    }

    public int getNum2() {
        return num2;
    }

    public void setNum2(int num2) {
        this.num2 = num2;
    }
    public int add() {
        return this.num1+this.num2;
    }
    public int sub() {
        return this.num1-this.num2;
    }
    public int mul() {
        return this.num1*this.num2;
    }
    public double dev () {
        return this.num1*1.0/this.num2;
    }
}

public class Test26 {
    public static void swap(MyValue val1,MyValue val2) {
        int tmp = val1.getNum1();
        val1.setNum1(val2.getNum1());
        val2.setNum1(tmp);
    }
    public static void main(String[] args) {
        /*MyValue val1 = new MyValue();
        val1.setNum1(10);
        MyValue val2 = new MyValue();
        val2.setNum1(20);
        System.out.println(val1.getNum1()+" "+val2.getNum1());
        swap(val1,val2);
        System.out.println(val1.getNum1()+" "+val2.getNum1());
         */
        /*Calculator calculator = new Calculator();
        calculator.setNum1(10);
        calculator.setNum2(20);
        System.out.println(calculator.add());
        System.out.println(calculator.sub());
        System.out.println(calculator.mul());
        System.out.println(calculator.dev());
         */
        MyArrayList myArrayList = new MyArrayList();
        for (int i = 0; i < myArrayList.getElem().length ; i++) {
            myArrayList.add(i,i);
        }
        myArrayList.display();
        myArrayList.add(10,10);
        myArrayList.display();
        System.out.println(myArrayList.contains(10));
        System.out.println(myArrayList.search(10));
        System.out.println(myArrayList.getPos(10));
        myArrayList.remove(3);
        myArrayList.display();
        myArrayList.add(3,3);
        myArrayList.display();
        myArrayList.setPos(0,100);
        myArrayList.display();
    }
}

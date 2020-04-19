public class Calculator {
private int num1;
private int num2;
    public Calculator() {

    }
    public Calculator(int num1, int num2) {
        this.num1 = num1;
        this.num2 = num2;

    }
    public int sum() {
        return this.num1+this.num2;
    }
    public int sub() {
        return this.num1-this.num2;
    }
    public int mul() {
        return this.num1*this.num2;
    }
    public double dev() {
        return this.num1*1.0/this.num2;
    }
}

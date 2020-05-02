package user;

import operation.BorrowOperation;
import operation.ExitOperation;
import operation.FindOperation;
import operation.ReturnOperation;

import java.util.Scanner;

public class NormalUser extends User{
    public NormalUser(String name) {
        super(name);
        this.iOperations[0] = new ExitOperation();
        this.iOperations[1] = new FindOperation();
        this.iOperations[2] = new BorrowOperation();
        this.iOperations[3] = new ReturnOperation();
    }

    @Override
    public int menu() {
        System.out.println("=====================");
        System.out.println("hello " + this.name + " 欢迎来到图书系统");
        System.out.println("1.查找图书");
        System.out.println("2.借阅图书");
        System.out.println("3.归还图书");
        System.out.println("0.退出系统");
        System.out.println("=====================");
        Scanner scan = new Scanner(System.in);
        int choice = scan.nextInt();
        return choice;
    }
}

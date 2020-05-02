import book.BookList;
import user.Admin;
import user.NormalUser;
import user.User;

import java.util.Scanner;

public class TestMain {
    private static User login() {
        Scanner scan = new Scanner(System.in);
        System.out.println("请输入姓名");
        String name = scan.nextLine();
        System.out.println("请输入身份");
        System.out.println("1.管理员>>>>>>>>>2.普通用户");
        int choice = scan.nextInt();
        if(choice == 1) {
            return new Admin(name);
        } else {
            return new NormalUser(name);
        }
    }
    public static void main(String[] args) {
        BookList bookList = new BookList();
        while(true) {
            User user = login();
            int choice = user.menu();
            user.doOperation(choice,bookList);
        }
    }
}

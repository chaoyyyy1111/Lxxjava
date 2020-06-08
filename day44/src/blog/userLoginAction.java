package blog;

import java.util.Scanner;

public class userLoginAction implements Action {
    @Override
    public void run() {
        Scanner scan = new Scanner(System.in);
        System.out.println("输入用户名");
        String un = scan.nextLine();
        System.out.println("输入密码");
        String pw = scan.nextLine();
        if(User.getCurrentUser().username.equals(un) &&
                User.getCurrentUser().username.equals(pw)) {
            System.out.println("登录成功");
        } else {


        }
    }
}

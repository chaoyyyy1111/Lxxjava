package blog;

public class User {

    int id;
    String username;
    String nickname;
    private static User currentUser = null;
   public static void login(User user) {
       currentUser = user;
       System.out.println(currentUser);
       System.out.println("登录成功");
   }

    public static User getCurrentUser() {
        return currentUser;
    }
    public static boolean isLoginned() {
       return currentUser != null;
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", username='" + username + '\'' +
                ", nickname='" + nickname + '\'' +
                '}';
    }
}

import java.util.ArrayList;
import java.util.List;

public class User {
String username;
String password;

    public User(String username, String password) {
        this.username = username;
        this.password = password;
    }
    public static List<User> userList = new ArrayList<>();
    static {
        userList.add(new User("lxx","123"));
        userList.add(new User("zxx","456"));
    }
    public static User login(String username,String password) {
        for(User user:userList) {
            if(user.username.equals(username) && user.password.equals(password) ) {
                return user;
            }
        }
        return null;
    }
}

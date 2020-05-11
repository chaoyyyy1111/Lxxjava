public class Test {
    private static String name = "lxx";
    private static String password = "123456";
    public static void login(String name,String password) throws UserException, PasswordException {
        if( !Test.name.equals(name) ) {
            throw new UserException("用户名错误");
        }
        if( !Test.password.equals(password)) {
            throw new PasswordException("密码错误");
        }
    }

    public static void main(String[] args) {
        try {
            login("lxx","123");
        } catch (UserException | PasswordException e) {
            e.printStackTrace();
        }
    }

}

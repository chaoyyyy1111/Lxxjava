public class MyException extends Exception {
    public MyException() {
    }

    public MyException(String message) {
        super(message);
    }
}
class UserException extends Exception {
    public UserException() {
        super();
    }

    public UserException(String message) {
        super(message);
    }
}
class PasswordException extends Exception {
    public PasswordException() {
        super();
    }

    public PasswordException(String message) {
        super(message);
    }
}
package operation;

import book.BookList;

public class ExitOperation extends IOperation {
    @Override
    public void walk(BookList bookList) {
        System.out.println("退出系统");
        System.exit(1);
    }
}

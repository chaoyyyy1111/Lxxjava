package operation;

import book.BookList;

public class ExitOperation extends IOperation {
    @Override
    public void work(BookList bookList) {
        System.exit(1);
    }
}

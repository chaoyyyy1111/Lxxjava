package user;

import book.BookList;
import operation.IOperation;

abstract public class User {
    protected String name;
    protected IOperation[] iOperations = new IOperation[10];
    public abstract int menu();
    public User(String name) {
        this.name = name;
    }
    public void doOperation(int choice, BookList bookList) {
          this.iOperations[choice].walk(bookList);
    }
}

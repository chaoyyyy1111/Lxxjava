package user;

import book.BookList;
import operation.IOperation;

import java.awt.print.Book;

abstract public class User {
    protected IOperation[] iOperations = new IOperation[10];
    protected String name;
    public abstract int menu();
    public User(String name) {
        this.name = name;
    }
    public void doOperation(int choice , BookList bookList) {
        this.iOperations[choice].work(bookList);
    }
}

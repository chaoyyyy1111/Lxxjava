package operation;

import book.Book;
import book.BookList;

import java.util.Scanner;

public class AddOperation extends IOperation {


    @Override
    public void walk(BookList bookList) {
        System.out.println("新增图书");
        Scanner scanner = new Scanner(System.in);
        System.out.println("请输入图书的名字：");
        String name = scanner.nextLine();
        System.out.println("请输入图书的作者：");
        String author = scanner.nextLine();
        System.out.println("请输入图书的价格：");
        int price = scanner.nextInt();
        System.out.println("请输入图书的类型：");
        String type = scanner.next();
        Book book = new Book(name,author,price,type);
        int curSize = bookList.getUsedSize();
        bookList.setBook(curSize,book);
        bookList.setUsedSize(curSize+1);
    }
}

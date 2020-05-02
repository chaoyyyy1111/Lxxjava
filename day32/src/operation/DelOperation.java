package operation;

import book.Book;
import book.BookList;

import java.util.Scanner;

public class DelOperation extends IOperation{
    @Override
    public void walk(BookList bookList) {
        System.out.println("删除图书");
        Scanner scanner = new Scanner(System.in);
        System.out.println("请输入图书的名字：");
        String name = scanner.nextLine();
        int i = 0;
        for (; i < bookList.getUsedSize();i++) {
            if(name.equals(bookList.getBook(i).getName()) == true) {
                break;
            }
        }
        if(i == bookList.getUsedSize()) {
            System.out.println("找不到你要删除的书籍");
            return;
        }
        for (int j = i; j < bookList.getUsedSize()-1; j++) {
            Book book=bookList.getBook(j+1);
            bookList.setBook(j,book);
        }
        int curSize = bookList.getUsedSize();
        bookList.setUsedSize(curSize-1);
        System.out.println("删除成功");
    }


}

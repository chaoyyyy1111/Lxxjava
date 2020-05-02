package operation;

import book.BookList;

import java.util.Scanner;

public class BorrowOperation extends IOperation{
    @Override
    public void walk(BookList bookList) {
        System.out.println("借阅图书");
        Scanner scanner = new Scanner(System.in);
        System.out.println("请输入图书的名字：");
        String name = scanner.nextLine();
        for (int i = 0; i < bookList.getUsedSize() ; i++) {
            if(name.equals(bookList.getBook(i).getName()) == true) {
                bookList.getBook(i).setBorrowed(true);
                System.out.println("借阅成功");
                return;
            }
        }
        System.out.println("找不到您要借阅的书");
    }
}

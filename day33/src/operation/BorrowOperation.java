package operation;

import book.BookList;

import java.util.Scanner;

public class BorrowOperation extends IOperation {
    @Override
    public void work(BookList bookList) {
        System.out.println("借阅图书");
        System.out.println("请输入要借图书的名字");
        Scanner scan = new Scanner(System.in);
        String name = scan.nextLine();
        for (int i = 0; i < bookList.getUsedSize(); i++) {
            if(name.equals(bookList.getBooks(i).getName()) == true) {
                bookList.getBooks(i).setBorrowed(true);
                System.out.println("借阅成功");
                return;
            }
        }
        System.out.println("找不到你要借阅的图书");
    }
}

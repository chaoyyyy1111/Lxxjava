package operation;

import book.BookList;

import java.util.Scanner;

public class ReturnOperation extends IOperation {
    @Override
    public void work(BookList bookList) {
        System.out.println("归还图书");
        System.out.println("请输入要归还图书的名字");
        Scanner scan = new Scanner(System.in);
        String name = scan.nextLine();
        for (int i = 0; i < bookList.getUsedSize(); i++) {
            if(name.equals(bookList.getBooks(i).getName()) == true) {
                bookList.getBooks(i).setBorrowed(false);
                System.out.println("归还成功");
                return;
            }
        }
        System.out.println("找不到你要归还的图书");
    }
}

package operation;

import book.BookList;

import java.util.Scanner;

public class FindOperation extends IOperation {
    @Override
    public void work(BookList bookList) {
        System.out.println("查找图书");
        System.out.println("请输入要查找图书的名字");
        Scanner scan = new Scanner(System.in);
        String name = scan.nextLine();
        for (int i = 0; i < bookList.getUsedSize(); i++) {
            if(name.equals(bookList.getBooks(i).getName()) == true) {
                System.out.println(bookList.getBooks(i));
                System.out.println("查找成功");
                return;
            }
        }
        System.out.println("找不到你要找的图书");
    }
    }


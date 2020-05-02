package operation;

import book.BookList;

import java.util.Scanner;

public class DelOperation extends IOperation {
    @Override
    public void work(BookList bookList) {
        System.out.println("删除图书");
        System.out.println("请输入要删除图书的名字");
        Scanner scan = new Scanner(System.in);
        String name = scan.nextLine();
        int i = 0;
        for (; i < bookList.getUsedSize(); i++) {
            if(name.equals(bookList.getBooks(i).getName()) == true) {
                break;
            }
        }
        if(i == bookList.getUsedSize()) {
            System.out.println("找不到你要删除的书籍");
        }
        for (int j = i; j < bookList.getUsedSize()-1; j++) {
            bookList.setBooks(i,bookList.getBooks(i+1));
            bookList.setUsedSize(bookList.getUsedSize()-1);
        }
        System.out.println("删除成功");
    }
}

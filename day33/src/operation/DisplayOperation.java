package operation;

import book.BookList;

public class DisplayOperation extends IOperation {
    @Override
    public void work(BookList bookList) {
        System.out.println("显示所有图书");
        for (int i = 0; i < bookList.getUsedSize(); i++) {
            System.out.println(bookList.getBooks(i));
        }
    }
}

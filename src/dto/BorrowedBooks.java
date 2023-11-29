// 작성자 : 김상규

package dto;

import entity.Book;

import java.util.List;

public class BorrowedBooks {
    private List<Book> books;

    public BorrowedBooks(List<Book> books) {
        this.books = books;
    }

    public List<Book> getBooks() {
        return books;
    }
}

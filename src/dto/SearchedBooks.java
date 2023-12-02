//작성자 : 박영주
package dto;

import entity.Book;

import java.util.List;
public class SearchedBooks
{
    private List<Book> books;

    public SearchedBooks(List<Book> books) {
        this.books = books;
    }

    public List<Book> getBooks() {
        return books;
    }
}

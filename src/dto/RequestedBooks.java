package dto;

import entity.Book;
import entity.BookRequest;

import java.util.List;

public class RequestedBooks {
    private List<BookRequest> requestedBooks;

    public RequestedBooks(List<BookRequest> books) {
        this.requestedBooks = books;
    }

    public List<BookRequest> getBooks() {
        return requestedBooks;
    }
}

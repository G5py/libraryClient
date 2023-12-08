package dto;

import entity.Book;

import java.util.List;

public class RequestedBooks {
    private List<RequestedBooks> requestedBooks;

    public RequestedBooks(List<RequestedBooks> books) {
        this.requestedBooks = books;
    }

    public List<RequestedBooks> getBooks() {
        return requestedBooks;
    }
}

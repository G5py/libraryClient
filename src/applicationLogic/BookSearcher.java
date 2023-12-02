//작성자 박영주
package applicationLogic;

import dto.BorrowedBooks;
import dto.SearchedBooks;
import entity.Book;
import repository.BookHashmapRepository;
import repository.BookRequestRepository;
import repository.RepositoryManager;

import java.util.List;
import java.util.stream.Collectors;

public class BookSearcher
{
    private BookHashmapRepository   bookRepository;

    public BookSearcher() {
        this.bookRepository   = RepositoryManager.getBookHashmapRepository();
    }

    public SearchedBooks search(String name) {
        List<Book> books = null;

        return new SearchedBooks(books);

    }

}

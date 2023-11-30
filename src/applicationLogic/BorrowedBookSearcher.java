// 작성자 : 김상규

package applicationLogic;

import dto.BorrowedBooks;
import entity.Book;
import repository.BookHashmapRepository;
import repository.MemberHashmapRepository;
import repository.RepositoryManager;

import java.util.List;
import java.util.stream.Collectors;

public class BorrowedBookSearcher {
    private BookHashmapRepository   bookRepository;
    private MemberHashmapRepository memberRepository;

    public BorrowedBookSearcher() {
        this.bookRepository   = RepositoryManager.getBookHashmapRepository();
        this.memberRepository = RepositoryManager.getMemberHashmapRepository();
    }

    public BorrowedBooks search(Integer id) {
        List<Book> books = memberRepository.findByKey(id)
                .getBookList().stream()
                .map(bookRepository::findByKey)
                .collect(Collectors.toList());

        return new BorrowedBooks(books);

    }


}

package applicationLogic;

import entity.Book;
import repository.BookHashmapRepository;
import repository.MemberHashmapRepository;
import repository.RepositoryManager;

import java.util.List;

public class BookBorrowManager {

    private BookHashmapRepository bookRepository;
    private MemberHashmapRepository memberRepository;

    public BookBorrowManager() {
        this.bookRepository   = RepositoryManager.getBookHashmapRepository();
        this.memberRepository = RepositoryManager.getMemberHashmapRepository();
    }

    public String borrowBook(String bookName, String userID) {

        List<Book> books = bookRepository.findByName(bookName);

        if (books.isEmpty()) {
            return "책을 찾을 수 없습니다.";
        }

        Book bookToBorrow = books.get(0);

        if (!bookToBorrow.getDate().equals("")) {
            return "해당 책은 이미 대출되어 있습니다.";
        }

        //책 상태 업데이트  날짜 사용하려면 import java.util.Date;사용 필요
        bookToBorrow.setDate("20231206");
        bookRepository.save(bookToBorrow.getNum(), bookToBorrow);
        //memberRepository.save(userID, );
        return "책 반납이 완료되었습니다.";
    }


}

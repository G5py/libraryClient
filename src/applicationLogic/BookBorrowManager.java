package applicationLogic;

import entity.Book;
import repository.BookHashmapRepository;
import repository.MemberHashmapRepository;
import repository.RepositoryManager;
import java.util.Date;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

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

        //현재시각 구하기
        LocalDateTime today = LocalDateTime.now();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy/MM/dd");
        String formattedTime = today.format(formatter);

        //book의 Date에 현재 시각 등록
        bookToBorrow.setDate(formattedTime);
        bookRepository.save(bookToBorrow.getNum(), bookToBorrow);
        //Member에 빌리 책의 키값 등록
        memberRepository.addBorrowedBookKey(userID, bookToBorrow.getNum());

        return "책 대출이 완료되었습니다.";
    }


}

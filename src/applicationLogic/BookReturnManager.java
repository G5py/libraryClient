package applicationLogic;

import entity.Book;
import repository.BookHashmapRepository;
import repository.MemberHashmapRepository;
import repository.RepositoryManager;

import java.util.List;

public class BookReturnManager {
    private BookHashmapRepository bookRepository;

    public BookReturnManager() {
        this.bookRepository   = RepositoryManager.getBookHashmapRepository();

    }
    public String returnBook(String bookName) {
        List<Book> books=bookRepository.findByName(bookName);
        if(books.isEmpty()){
            return "책을 찾을 수 없습니다.";
        }
        Book bookToReturn=books.get(0);

        if(bookToReturn.getDate()==""){
            return "해당 책은 대출되어 있지 않습니다.";
        }

        //책 상태 업데이트  날짜 사용하려면 import java.util.Date;사용 필요
        bookToReturn.setDate("20231204");
        bookRepository.save(bookToReturn.getNum(), bookToReturn);
        return "책 반납이 완료되었습니다.";
    }


}

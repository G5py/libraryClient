package applicationLogic;

import entity.BookRequest;
import repository.BookRequestRepository;
import repository.RepositoryManager;

public class BookRequestmanager {
    private final BookRequestRepository repository;
    public BookRequestmanager() {
        this.repository = RepositoryManager.getBookRequestRepository();
    }

    public String bookRequest(String name,String writer, String publisher, String id){
        BookRequest bookRequest=new BookRequest(name,writer,publisher,id);
        //repository.save();

        return "success";
    }



}

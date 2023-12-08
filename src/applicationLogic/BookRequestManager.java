package applicationLogic;

import dto.RequestedBooks;
import entity.BookRequest;
import entity.RequestState;
import repository.BookRequestRepository;
import repository.RepositoryManager;

import java.util.List;

public class BookRequestManager {
    private final BookRequestRepository repository;
    public BookRequestManager() {
        this.repository = RepositoryManager.getBookRequestRepository();
    }

    //리퀘스트 등록
    public void saveBookRequest(String name,String writer, String publisher, String id){
        BookRequest bookRequest=new BookRequest(name,writer,publisher,id);
        repository.save(repository.returnSize(),bookRequest);
    }
    //리퀘스트 검색
    public RequestedBooks searchRequestAll(){
        return new RequestedBooks(repository.findAll());
    }
/*    public List<BookRequest> searchRequestByName(String name){
        return repository.findByName(name);
    }
    public List<BookRequest> searchRequestById(String id){
        return repository.findById(id);
    }*/

    public void requestAcception(int key, RequestState state){
        repository.setAccept(key,state);

    }



}

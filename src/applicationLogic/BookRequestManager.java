package applicationLogic;

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
    public String saveBookRequest(String name,String writer, String publisher, String id){
        BookRequest bookRequest=new BookRequest(name,writer,publisher,id);
        repository.save(1,bookRequest);
        return "success";
    }
    //리퀘스트 검색
    public List<BookRequest> searchRequestAll(){
        return repository.findAll();
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

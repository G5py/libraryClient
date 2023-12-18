package repository;

import entity.BookRequest;
import entity.RequestState;


import java.util.List;

public class BookRequestRepository extends HashmapRepository<Integer, BookRequest>{


    public BookRequest save( BookRequest entity) {
        return hashMap.put(hashMap.size(), entity);

    }

    public List<BookRequest> findById(String id){
        return findAll().stream().filter(n->n.getRequesterId().equals(id)).toList();
    }
    public List<BookRequest> findByName(String name){
        return findAll().stream().filter(n->n.getName().contains(name)).toList();
    }
    public void setAccept(int key,RequestState state){
        hashMap.get(key).setState(state);
    }
    public int returnSize(){
        return hashMap.size();
    }
}

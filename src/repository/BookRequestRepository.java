package repository;

import entity.Book;
import entity.BookRequest;

import java.util.List;

public class BookRequestRepository extends HashmapRepository<Integer, BookRequest>{

    public List<BookRequest> findById(String id){
        return findAll().stream().filter(n->n.getRequesterId().equals(id)).toList();
    }
    public List<BookRequest> findByName(String name){
        return findAll().stream().filter(n->n.getName().contains(name)).toList();

    }

}

package repository;

import entity.Book;

import java.util.List;
import java.util.stream.Collectors;

public class BookHashmapRepository extends HashmapRepository<Integer, Book> {
    public List<Book> findByName(String name) {
        List<Book> all = findAll();
        return all.stream()
                .filter(x -> x.getName().contains(name))
                .collect(Collectors.toList());
    }
}

package repository;

import java.util.List;

public interface Repository <K, T> {
    public T save(K key, T entity);
    public List<T> findAll();
    public T findByKey(K key);
}

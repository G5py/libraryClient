package repository;

import java.util.List;

public interface Repository <K, T> {
    public boolean save(K key, T entity);
    public List<T> findAll();
    public T findByKey(K key);
}

package repository;

import java.util.HashMap;
import java.util.List;

public class HashmapRepository<K, T> implements Repository<K, T> {
    protected HashMap<K, T> hashMap;
    @Override
    public boolean save(K key, T entity) {
        T put = hashMap.put(key, entity);

        if (put == null) {
            return false;
        }

        return true;
    }

    @Override
    public List<T> findAll() {
        return hashMap.values().stream().toList();
    }

    @Override
    public T findByKey(K key) {
        return hashMap.get(key);
    }


}

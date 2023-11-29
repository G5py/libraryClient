// 작성자 : 김상규

package repository;

import java.util.HashMap;
import java.util.List;

public class HashmapRepository<K, T> implements Repository<K, T> {
    protected HashMap<K, T> hashMap;
    @Override
    public T save(K key, T entity) {
        return hashMap.put(key, entity);
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

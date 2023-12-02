// 작성자 : 김상규

package repository;

import java.util.HashMap;
import java.util.List;
import java.util.stream.Collectors;

public class HashmapRepository<K, T> implements Repository<K, T> {
    protected HashMap<K, T> hashMap;
    @Override
    public T save(K key, T entity) {
        return hashMap.put(key, entity);
    }

    @Override
    public List<T> findAll() {
        //LibraryCli를 테스트하는 과정에 있어서 컴파일 에러가 나서 일시적으로 수정해뒀습니다. 나중에 바꿔주세요!
        //원본코드: return hashMap.values().stream().toList();
        return hashMap.values().stream().collect(Collectors.toList());
    }

    @Override
    public T findByKey(K key) {
        return hashMap.get(key);
    }


}

// 작성자 : 김상규

package repository;

import entity.Member;

import java.util.HashMap;
import java.util.Map;

public class MemberHashmapRepository extends HashmapRepository<String, Member> {
    private Map<String, String> userCredentials;

    public MemberHashmapRepository() {
        userCredentials = new HashMap<>();

        userCredentials.put("aaa", "aaa1234");
        userCredentials.put("bbb", "bbb1234");
    }

    public boolean checkCredentials(String username, String password) {
        return userCredentials.containsKey(username) && userCredentials.get(username).equals(password);
    }

    // 사용자 추가
    public void addUser(String username, String password) {
        userCredentials.put(username, password);
    }

    public boolean checkUsernameExists(String username) {
        return userCredentials.containsKey(username);
    }
}
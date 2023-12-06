// 작성자 : 김상규

package repository;

import entity.Member;

import java.util.Collections;


public class MemberHashmapRepository extends HashmapRepository<String, Member> {


    public MemberHashmapRepository() {
        //테스트용
        hashMap.put("bbb", new Member("bbb","1234",Collections.emptyList()));
    }

    public boolean checkCredentials(String username, String password) {
        return hashMap.containsKey(username) && hashMap.get(username).getPassword().equals(password);
    }

    // 사용자 추가
    public void addUser(String username, String password) {
        hashMap.put(username, new Member(username,password, Collections.emptyList()));
    }

    public boolean checkUsernameExists(String username) {
        return hashMap.containsKey(username);
    }

    public void setAuth(String id,boolean auth){
        hashMap.get(id).setAuth(auth);
    }
    public boolean getAuth(String id) {
        return hashMap.get(id).getAuth();
    }
    public boolean checkAuthCode(String code){
        return Member.getCODE().equals(code);
    }

    public void addBorrowedBookKey(String userID, int bookID){
        hashMap.get(userID).addBookList(bookID);
    }

}
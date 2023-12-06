// 작성자 : 김상규

package repository;

import entity.Member;


public class MemberHashmapRepository extends HashmapRepository<String, Member> {
    private HashmapRepository<String,String> userCredentials;

    public MemberHashmapRepository() {
        userCredentials = new HashmapRepository<>();

        userCredentials.save("aaa", "aaa1234");
        userCredentials.save("bbb", "bbb1234");
    }

    public boolean checkCredentials(String username, String password) {
        return userCredentials.containsKey(username) && userCredentials.findByKey(username).equals(password);
    }

    // 사용자 추가
    public void addUser(String username, String password) {
        userCredentials.save(username, password);
    }

    public boolean checkUsernameExists(String username) {
        return userCredentials.containsKey(username);
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
        hashMap.get(userID).getBookList().add(bookID);
    }

}
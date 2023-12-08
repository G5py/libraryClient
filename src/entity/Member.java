// 작성자 : 김상규, 최연호

package entity;

import java.util.ArrayList;
import java.util.List;

public class Member {
    private String id;
    private String password;
    private boolean auth= false;
    private List<Integer> bookList;

    public Member(String id, String password, List<Integer> bookList) {
        this.id = id;
        this.password = password;
        this.bookList = new ArrayList<>();
    }

    public boolean getAuth(){return auth;}
    public String getId() {
        return id;
    }

    public void setAuth(boolean auth) {
        this.auth = auth;
    }

    public String getPassword() {
        return password;
    }

    public List<Integer> getBookList() {
        return bookList;
    }
}

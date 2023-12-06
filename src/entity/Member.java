// 작성자 : 김상규, 최연호

package entity;

import java.util.List;

public class Member {
    private String id;
    private String password;
    private boolean auth= false;
    private List<Integer> bookList;
    private static String CODE="authCheck";

    public Member(String id, String password, List<Integer> bookList) {
        this.id = id;
        this.password = password;
        this.bookList = bookList;
    }

    public static String getCODE(){return CODE;}
    public boolean getAuth(){return auth;}
    public void setAuth(boolean auth){this.auth=auth;}
    public String getId() {
        return id;
    }

    public String getPassword() {
        return password;
    }

    public List<Integer> getBookList() {
        return bookList;
    }

    public void addBookList(int bookID) { bookList.add(bookID); }
}

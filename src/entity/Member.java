package entity;

import java.util.List;

public class Member {
    private String id;
    private String password;
    private List<Integer> bookList;

    public Member(String id, String password, List<Integer> bookList) {
        this.id = id;
        this.password = password;
        this.bookList = bookList;
    }

    public String getId() {
        return id;
    }

    public String getPassword() {
        return password;
    }

    public List<Integer> getBookList() {
        return bookList;
    }
}

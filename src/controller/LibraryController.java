package controller;

import applicationLogic.*;
import dto.*;
import entity.Book;
import java.util.List;
import javax.swing.table.DefaultTableModel;

public class LibraryController {

    //임시 아이디 넣어놓음, 비로그인 상황 보고싶으면 비워둘 것
    private String userId = "";

    public String getUserId() { return userId; }

    public void setUserId(String userId) { this.userId = userId; }

    public boolean isLoggedIn() { return !userId.equals(""); }

    public boolean login(String id, String pw) {
        LoginManager loginManager = new LoginManager();
        boolean isLoginSuccess = loginManager.login(id,pw);
        if(isLoginSuccess)
        {
            setUserId(id);
        }
        return isLoginSuccess;
    }

    public int register(String id, String pw) {
        RegistrationManager registrationManager = new RegistrationManager();
        int isRegisterSuccess = registrationManager.register(id,pw);
        return isRegisterSuccess;
    }

    public SearchedBooks searchBookByName(String bookName){
        BookSearcher bookSearcher = new BookSearcher();
        SearchedBooks searchedBooks = bookSearcher.search(bookName);

        return searchedBooks;
    }

    public String borrowBook(String name){
        if(!isLoggedIn())
        {
            return "로그인 후 이용하세요";
        }
        BookBorrowManager bookBorrowManager = new BookBorrowManager();
        return "미구현";
    }

    public String returnBook(String name){
        if(!isLoggedIn())
        {
            return "로그인 후 이용하세요";
        }
        BookReturnManager bookReturnManager = new BookReturnManager();
        return "미구현";
    }

    public BorrowedBooks searchBorrowedBook() {
        BorrowedBookSearcher borrowedBookSearcher = new BorrowedBookSearcher();
        BorrowedBooks borrowedBooks = borrowedBookSearcher.search(userId);
        return borrowedBooks;
    }

    public String request(String book, String author, String publisher) {
        if(!isLoggedIn())
        {
            return  "로그인 후 이용하세요";
        }
        BookRequestmanager bookRequestmanager = new BookRequestmanager();
        return "미구현";
    }

}

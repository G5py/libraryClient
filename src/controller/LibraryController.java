package controller;

import applicationLogic.*;
import dto.*;
import entity.BookRequest;
import entity.Member;
import entity.RequestState;

import java.util.List;

public class LibraryController {

    private final BookRequestManager bookRequestmanager;
    public LibraryController(){
        bookRequestmanager = new BookRequestManager();

    }

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
        return bookBorrowManager.borrowBook(name,userId);
    }

    public String returnBook(String bookName){
        if(!isLoggedIn())
        {
            return "로그인 후 이용하세요";
        }
        BookReturnManager bookReturnManager = new BookReturnManager();
        return bookReturnManager.returnBook(bookName);
    }

    public BorrowedBooks searchBorrowedBook() {
        BorrowedBookSearcher borrowedBookSearcher = new BorrowedBookSearcher();
        BorrowedBooks borrowedBooks = borrowedBookSearcher.search(getUserId());
        return borrowedBooks;
    }

    public String request(String book, String author, String publisher) {
        if(!isLoggedIn())
        {
            return  "로그인 후 이용하세요";
        }
        bookRequestmanager.saveBookRequest(book,author,publisher,userId);
        return "요청 성공";
    }
    public void showRequestAll(){
        List<BookRequest> list=bookRequestmanager.searchRequestAll();
        for(int i=0;i<list.size();i++){
            System.out.println(list);
        }
    }
    /*public void showRequestByName(String name){
        List<BookRequest> list=bookRequestmanager.searchRequestByName(name);
        for(int i=0;i<list.size();i++){
            System.out.println(list);
        }
    }
    public void showRequestById(String Id){
        List<BookRequest> list=bookRequestmanager.searchRequestById(Id);
        for(int i=0;i<list.size();i++){
            System.out.println(list);
        }
    }*/
    //권한이 있는경우, 도서 신청 승인 절차로 들어감.
    public void requestAcception(int key,RequestState state){
        if(!isLoggedIn())
        {
            System.out.println("로그인 후 이용해주세요.");
        }
        if(checkAuth(getUserId())){
            bookRequestmanager.requestAcception(key, state);
            System.out.println("승인했습니다.");
        }
        else
            System.out.println("권한이 없습니다.");
    }
    //사용자의 권한을 확인
    public boolean checkAuth(String id){
     //미구현
        LoginManager loginManager=new LoginManager();
        return loginManager.checkAuth(id);
    }
    //static으로 저장되어있는 코드를 입력하면 권한을 허가로 변경
    public void setAuth(String id, String code){
        LoginManager loginManager=new LoginManager();
        loginManager.setAuth(id,code);

    }


}

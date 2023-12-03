package controller;

import applicationLogic.*;
import dto.*;
import entity.Book;
import java.util.List;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
public class LibraryController {
    private static String userId = "";
    public void setUserId(String userId)
    {
        this.userId = userId;
    }
    public boolean login(String id, String pw) {
        LoginManager loginManager = new LoginManager();
        boolean isLoginSuccess = loginManager.login(id,pw);
        //login 성공 or 실패에 대한 내부 로직, String id,pw를 사용
        //login에 성공한다면 isLoginSuccess에 true를, 실패한다면 false를 대입
        if(isLoginSuccess==true)
        {
            setUserId(id);
        }
        return isLoginSuccess;
    }

    public int register(String id, String pw) {
        RegistrationManager registrationManager = new RegistrationManager();
        int isRegisterSuccess = registrationManager.register(id,pw);
        //register 성공 or 실패에 대한 내부 로직, String id,pw를 사용
        //id, pw가 이미 존재하는지 체크해주고 존재하지 않는다면 0, 존재한다면 1을 isRegisterSuccess에 대입
        //추가적으로 id와 pw가 같다거나, 입력한 문자가 너무 길다거나하는 상황이 있을 수 있어서 int로 해둠
        //근데 사실 그리 안중요하니 0,1로도 충분할 듯
        return isRegisterSuccess;
    }

    //이건 건드릴 필요 없음
    static class NonEditableModel extends DefaultTableModel {
        public NonEditableModel(Object[] columnNames, int rowCount) {
            super(columnNames, rowCount);
        }
        // 모든 셀을 변경 불가능하게 설정
        @Override
        public boolean isCellEditable(int row, int column) {
            return false; // 셀을 편집할 수 없도록 false 반환
        }
    }

    public NonEditableModel addBookData() {
        NonEditableModel model = new NonEditableModel(new Object[]{"고유번호", "도서명", "저자", "출판사"}, 0);
        //DefaultTableModel을 수정한 클래스 NonEditableModel로 지정된 model 객체를 UI로 보내주는 메서드
        //아래는 샘플데이터로 실제로 구현할 때는 Repository의 Hashmap 정보를 String또는 Object으로 변환해 model.addRow로 한줄 씩 정보를 추가해줘야함
        //for문으로 데이터 개수만큼 추가하는 함수를 만들면 될듯
        //해당 메서드는 도서 검색(createSearchPanel)에서 사용됨
        //데이터 가져오는 메서드 구현이 완료되면 아래 데이터는 제거함
        //model.addRow(new Object[]{"978-0-13-468599-1", "Effective Java", "Joshua Bloch", "Addison-Wesley"});
        //model.addRow(new Object[]{"978-0-59-600920-5", "Head First Java", "Kathy Sierra & Bert Bates", "O'Reilly Media"});
        //model.addRow(new Object[]{"978-0-13-235088-4", "Clean Code", "Robert C. Martin", "Prentice Hall"});
        //model.addRow(new Object[]{"978-1-491-94765-0", "Java Concurrency in Practice", "Brian Goetz", "Addison-Wesley"});
        return model;
    }

    public boolean seachedBookExists(String name){
        boolean isSearchedBookExists = true;

        //검색결과 일치하는 도서명이 있는지 확인하는 메서드
        //일치하는 도서명이 있다면 isSearchedBookExists에 true를, 없다면 false를 대입
        return isSearchedBookExists;
    }

    public NonEditableModel searchBookByName(String bookName){
        int bookId;
        String name, writer, publisher;
        NonEditableModel model = new NonEditableModel(new Object[]{"고유번호", "도서명", "저자", "출판사"}, 0);
        BookSearcher bookSearcher = new BookSearcher();
        SearchedBooks searchedBooks = bookSearcher.search(bookName);
        List<Book> bookList = searchedBooks.getBooks();
        for(int i=0;i<bookList.size();i++)
        {
            bookId = bookList.get(i).getNum();
            name = bookList.get(i).getName();
            writer = bookList.get(i).getWriter();
            publisher = bookList.get(i).getPublisher();
            String bookIdString = String.valueOf(bookId);
            model.addRow(new Object[]{bookIdString, name, writer, publisher});
        }
        //가져온 BookRepository 데이터에서 도서명으로 검색하는 기능 구현
        //UI에선 위의 boolean 메서드로 검색한 책이 존재하는지 미리 판별 후, 존재한다면 이 메서드 실행
        //name으로 받아온 값을 기반으로 검색 수행, 일치하는 행이 있으면 searchModel.add로 위와 같이 row 추가
        //아래는 샘플데이터로 구현 완료되면 제거
        //searchModel.addRow(new Object[]{"978-1-118-95119-2", "Beginning Java 8 Fundamentals", "Kishori Sharan", "Wrox"});
        return model;
    }

    public void borrowBook(String name){
        if(userId.equals(""))
        {
            //return ...
        }
        BookBorrowManager bookBorrowManager = new BookBorrowManager();
        //책 빌리는 메서드
        //Member관련 레포지토리에 해당 책의 키값 등록
        //Book 레포지토리에 빌린 날짜 등록
    }

    public void returnBook(String name){
        if(userId.equals(""))
        {
            //return ...
        }
        BookReturnManager bookReturnManager = new BookReturnManager();
        //책 반납하는 메서드
        //Member관련 레포지토리에서 해당 책의 키값 삭제
        //Book 레포지토리에 빌린 날짜 삭제
    }

    public NonEditableModel addBorrowedBookData() {
        if(userId.equals(""))
        {
            NonEditableModel dummyModel = new NonEditableModel(new Object[]{"고유번호", "도서명", "저자", "출판사"}, 0);
            return dummyModel;
        }
        BorrowedBookSearcher borrowedBookSearcher = new BorrowedBookSearcher();
        //에러걸리면 여기서부터 for문까지 전부 주석처리;
        int bookId;
        String name, writer, publisher;
        NonEditableModel model = new NonEditableModel(new Object[]{"고유번호", "도서명", "저자", "출판사"}, 0);
        BorrowedBooks borrowedBooks = borrowedBookSearcher.search(userId);
        List<Book> bookList = borrowedBooks.getBooks();
        for(int i=0;i<bookList.size();i++)
        {
            bookId = bookList.get(i).getNum();
            name = bookList.get(i).getName();
            writer = bookList.get(i).getWriter();
            publisher = bookList.get(i).getPublisher();
            String bookIdString = String.valueOf(bookId);
            model.addRow(new Object[]{bookIdString, name, writer, publisher});
        }
        //빌린 책 데이터 가져오는 메서드
        //Member 레포지토리의 키값 참조해서 가져오면 될듯
        //데이터 가져오는 메서드 구현이 완료되면 아래의 더미 데이터는 제거함
        //에러걸리면 여기 주석해제
        //NonEditableModel model = new NonEditableModel(new Object[]{"고유번호", "도서명", "저자", "출판사"}, 0);
        //model.addRow(new Object[]{"978-0-13-468599-1", "Effective Java", "Joshua Bloch", "Addison-Wesley"});
        //model.addRow(new Object[]{"978-0-59-600920-5", "Head First Java", "Kathy Sierra & Bert Bates", "O'Reilly Media"});
        return model;
    }

    public int request(String book, String author, String publisher) {
        if(userId.equals(""))
        {
            //return ...
        }
        BookRequestmanager bookRequestmanager = new BookRequestmanager();
        int requestState = 1;
        //request 성공 or 실패에 대한 내부 로직
        //도서명에 입력된 항목이 존재하지 않는다면 0, 이미 있다면 1, 로그인이 안되어있으면 2
        //요청에 성공했으면 BookRequest 레포지토리 수정하면 될듯
        //추가적인 상황이 있다면 해당 상황을 requestState에 부여하고 알려주셈
        return requestState;
    }

}

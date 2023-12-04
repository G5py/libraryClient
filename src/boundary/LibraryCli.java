package boundary;

import controller.LibraryController;
import entity.Book;

import java.util.List;
import java.util.Scanner;
public class LibraryCli
{
    LibraryController libraryController = new LibraryController();
    Scanner scanner = new Scanner(System.in);

    public LibraryCli()
    {
        System.out.println("도서관 클라이언트에 오신것을 환영합니다.");
        mainMenu();
    }

    public void mainMenu()
    {
        while(true){
        System.out.println("원하시는 항목을 선택하십시오.\n[1] 도서검색\n[2] 도서대출\n[3] 도서반납\n[4] 빌린도서목록조회\n[5] 로그인\n[6] 회원가입");
        System.out.print("입력 : ");
        int choice = scanner.nextInt();
        switch (choice) {
            case 1:
                searchBook();
                break;
            case 2:
                borrowBook();
                break;
            case 3:
                returnBook();
                break;
            case 4:
                displayBorrowedBook();
                break;
            case 5:
                login();
                break;
            case 6:
                register();
                break;
            default:
                System.out.println("잘못된 입력입니다.");
                break;
            }
        }
    }
    public void searchBook()
    {

    }
    public void returnBook()
    {

    }
    public void borrowBook()
    {

    }
    public void displayBorrowedBook()
    {

    }
    public void login()
    {
        String id, pw;
        System.out.print("id 입력 : ");
        id = scanner.next();

        System.out.print("pw 입력 : ");
        pw = scanner.next();

        boolean loginSuccess = libraryController.login(id,pw);
        if(loginSuccess==true)
        {
            System.out.println("로그인 성공");
        }
        else
        {
            System.out.println("로그인 실패");
        }
    }
    public void register()
    {

    }
}
/*
    int bookId;
    String name, writer, publisher;
    LibraryController.NonEditableModel model = new LibraryController.NonEditableModel(new Object[]{"고유번호", "도서명", "저자", "출판사"}, 0);
    List<Book> bookList = searchedBooks.getBooks();
        for (Book book : bookList) {
                bookId = book.getNum();
                name = book.getName();
                writer = book.getWriter();
                publisher = book.getPublisher();
                String bookIdString = String.valueOf(bookId);
                model.addRow(new Object[]{bookIdString, name, writer, publisher});
                } */
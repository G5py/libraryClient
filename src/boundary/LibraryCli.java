package boundary;

import controller.LibraryController;
import dto.BorrowedBooks;
import dto.SearchedBooks;
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
            System.out.println("------------------------------------------------------------");
        System.out.println("원하시는 항목을 선택하십시오.\n[1] 도서검색\n[2] 도서대출\n[3] 도서반납\n[4] 빌린도서목록조회\n[5] 책 요청\n[6] 로그인\n[7] 회원가입\n[8] 종료");
        System.out.print("입력 : ");
        int choice = scanner.nextInt();
        scanner.nextLine();
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
                request();
                break;
            case 6:
                login();
                break;
            case 7:
                register();
                break;
            case 8:
                System.out.println("시스템을 종료합니다.");
                return;
            default:
                System.out.println("잘못된 입력입니다.");
                break;
            }
        }
    }
    public void searchBook()
    {
        String nameInput;
        System.out.print("책 이름 입력 : ");
        nameInput = scanner.nextLine();
        SearchedBooks searchedBooks = libraryController.searchBookByName(nameInput);
        List<Book> bookList = searchedBooks.getBooks();
        if(bookList.size() == 0)
        {
            System.out.println("해당되는 책이 없습니다.");
            return;
        }
        printBooks(bookList);
    }
    public void returnBook()
    {
        String nameInput;
        System.out.print("책 이름 입력 : ");
        nameInput = scanner.nextLine();
        String message = libraryController.returnBook(nameInput);
        System.out.println(message);
    }
    public void borrowBook()
    {
        String nameInput;
        System.out.print("책 이름 입력 : ");
        nameInput = scanner.nextLine();
        String message = libraryController.borrowBook(nameInput);
        System.out.println(message);
    }
    public void displayBorrowedBook()
    {
        BorrowedBooks borrowedBooks = libraryController.searchBorrowedBook();
        List<Book> bookList = borrowedBooks.getBooks();
        printBooks(bookList);
    }

    public void request()
    {
        String book, author, publisher, message;
        System.out.print("책이름 입력 : ");
        book = scanner.nextLine();
        System.out.print("작가 입력 : ");
        author = scanner.nextLine();
        System.out.print("출판사 입력 : ");
        publisher = scanner.nextLine();
        message = libraryController.request(book, author, publisher);
        System.out.println(message);

    }
    public void login()
    {
        String id, pw;
        System.out.print("id 입력 : ");
        id = scanner.next();
        scanner.nextLine();

        System.out.print("pw 입력 : ");
        pw = scanner.next();
        scanner.nextLine();

        boolean loginSuccess = libraryController.login(id,pw);
        if(loginSuccess)
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
        String id, pw;
        System.out.print("id 입력 : ");
        id = scanner.next();
        scanner.nextLine();

        System.out.print("pw 입력 : ");
        pw = scanner.next();
        scanner.nextLine();

        int registerSuccessNum = libraryController.register(id,pw);
        switch(registerSuccessNum)
        {
            case 0:
                System.out.println("회원가입 성공");
                return;
            case 1:
                System.out.println("회원가입 실패");
                return;
        }
    }
    public void printBooks(List<Book> books)
        {
            int bookId;
            String name, writer, publisher;
            for (Book book : books) {
                bookId = book.getNum();
                name = book.getName();
                writer = book.getWriter();
                publisher = book.getPublisher();
                System.out.println("[고유번호] : " + bookId + ", [이름] : " + name + ", [작가] : " + writer + ", [출판사] : " + publisher);
            }
        }
}
package boundary;

import controller.LibraryController;
import dto.BorrowedBooks;
import dto.RequestedBooks;
import dto.SearchedBooks;
import entity.Book;
import entity.BookRequest;
import entity.RequestState;

import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;
public class LibraryCli
{
    private LibraryController libraryController = new LibraryController();
    private Scanner scanner = new Scanner(System.in);

    public LibraryCli()
    {
        System.out.println("도서관 클라이언트에 오신것을 환영합니다.");
        mainMenu();
    }

    public void mainMenu()
    {
        while(true){
            System.out.println("------------------------------------------------------------");
        System.out.println("원하시는 항목을 선택하십시오.\n[1] 도서검색\n[2] 도서대출\n[3] 도서반납\n[4] 빌린도서목록조회\n[5] 도서요청\n[6] 로그인\n[7] 회원가입\n[8] 종료");
        System.out.print("입력 : ");
        int choice=0;
        try{
            choice= scanner.nextInt();
        }catch (InputMismatchException e) {
            System.out.println("올바른 정수를 입력하세요.");
        }
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
                requestMenu();
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
    
    private void searchBook()
    {
        String nameInput;
        System.out.print("책 이름 입력 : ");
        nameInput = scanner.nextLine();
        SearchedBooks searchedBooks = libraryController.searchBookByName(nameInput);
        List<Book> bookList = searchedBooks.getBooks();
        if(bookList.isEmpty())
        {
            System.out.println("해당되는 책이 없습니다.");
            return;
        }
        printBooks(bookList);
    }
    
    private void returnBook()
    {
        String nameInput;
        System.out.print("책 이름 입력 : ");
        nameInput = scanner.nextLine();
        String message = libraryController.returnBook(nameInput);
        System.out.println(message);
    }
    
    private void borrowBook()
    {
        String nameInput;
        System.out.print("책 이름 입력 : ");
        nameInput = scanner.nextLine();
        String message = libraryController.borrowBook(nameInput);
        System.out.println(message);
    }
    
    private void displayBorrowedBook()
    {
        BorrowedBooks borrowedBooks = libraryController.searchBorrowedBook();
        List<Book> bookList = borrowedBooks.getBooks();
        if(bookList.isEmpty())
        {
            System.out.println("빌린 책이 없습니다.");
            return;
        }
        printBooks(bookList);
    }

    private void requestMenu()
    {
        RequestedBooks requestedBooks = libraryController.searchAllRequest();
        List<BookRequest> bookRequests = requestedBooks.getBooks();

        printRequests(bookRequests);
        System.out.println("------------------------------------------------------------");
        System.out.println("원하시는 항목을 선택하십시오.\n[1] 책 요청\n[2] 요청된 책 승인");
        System.out.print("입력 : ");
        int choice = scanner.nextInt();
        scanner.nextLine();
        switch (choice) {
            case 1:
                requestBook();
                break;
            case 2:
                acceptRequest();
                break;
            default:
                return;
        }
    }
    
    private void requestBook()
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
    
    private void acceptRequest()
    {
        int requestNum;
        RequestState requestState = RequestState.WAITING;
        System.out.print("요청번호 입력 : ");
        requestNum = scanner.nextInt();
        scanner.nextLine();
        System.out.println("해당 요청의 승인여부를 설정해주세요.\n[1] 승인\n[2] 거부");
        System.out.print("입력 : ");
        int choice = scanner.nextInt();
        scanner.nextLine();
        switch (choice) {
            case 1:
                requestState = RequestState.ACCEPT;
                break;
            case 2:
                requestState = RequestState.REJECT;
                break;
            default:
                return;
        }
        try {
            libraryController.requestAcception(requestNum,requestState);
        }catch (NullPointerException e){
            System.out.println("없는 요청 번호입니다.");
        }

    }
    
    private void login()
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
    
    private void register()
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
    
    private void printBooks(List<Book> books)
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
    
    private void printRequests(List<BookRequest> bookRequests)
    {
        String name, writer, publisher,applicant,state;
        for (int i=0;i<bookRequests.size();i++) {
            name = bookRequests.get(i).getName();
            writer = bookRequests.get(i).getWriter();
            publisher = bookRequests.get(i).getPublisher();
            applicant = bookRequests.get(i).getRequesterId();
            state = String.valueOf(bookRequests.get(i).getState());
            System.out.println("["+i+"] "+ "[이름] : " + name + ", [작가] : " + writer + ", [출판사] : " + publisher + ", [신청자] : " + applicant + ", [상태] : " + state);
        }
    }
}

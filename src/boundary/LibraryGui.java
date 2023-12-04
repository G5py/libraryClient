package boundary;

//건휘가 나중에 직접 처리한다고 하여 남겨둠
/*
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

import controller.LibraryController;

public class LibraryGui extends JFrame {
    private LibraryController controller;
    private CardLayout cardLayout;
    private JPanel cardPanel;
    private final int screenWidth = 1200;
    private final int screenHeight = 800;

    public LibraryGui(LibraryController controller) {
        this.controller = controller;
        initialize();
    }

    private void initialize() {
        setTitle("도서관 관리 시스템");
        setSize(1200, 800);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        cardLayout = new CardLayout();
        cardPanel = new JPanel(cardLayout);

        // 메인 메뉴 패널
        JPanel mainMenuPanel = new JPanel();
        JButton loginButton = new JButton("로그인");
        JButton registerButton = new JButton("회원가입");
        JButton searchButton = new JButton("도서 검색");
        JButton borrowButton = new JButton("도서 대출");
        JButton returnButton = new JButton("도서 반납");
        JButton checkoutButton = new JButton("대출한 도서 조회");
        JButton requestButton = new JButton("도서 요청");

        mainMenuPanel.add(loginButton);
        mainMenuPanel.add(registerButton);
        mainMenuPanel.add(searchButton);
        mainMenuPanel.add(borrowButton);
        mainMenuPanel.add(returnButton);
        mainMenuPanel.add(checkoutButton);
        mainMenuPanel.add(requestButton);

        // 로그인 패널
        JPanel loginPanel = createLoginPanel();

        // 회원가입 패널
        JPanel registerPanel = createRegisterPanel();

        // 도서 검색 패널
        JPanel searchPanel = createSearchPanel();

        // 도서 대출 패널
        JPanel borrowPanel = createBorrowPanel();

        // 도서 반납 패널
        JPanel returnPanel = createReturnPanel();

        //빌린 책 조회 패널
        JPanel checkoutPanel = createCheckoutPanel();

        //도서 요청 패널
        JPanel requestPanel = createRequestPanel();

        // 카드 패널에 각 패널 추가
        cardPanel.add(mainMenuPanel, "Main Menu");
        cardPanel.add(loginPanel, "Login");
        cardPanel.add(registerPanel, "Register");
        cardPanel.add(searchPanel, "Search");
        cardPanel.add(borrowPanel, "Borrow");
        cardPanel.add(returnPanel, "Return");
        cardPanel.add(checkoutPanel, "CheckOut");
        cardPanel.add(requestPanel, "Request");

        // 버튼 이벤트 리스너
        //로그인 필요 없는 기능
        loginButton.addActionListener(e -> cardLayout.show(cardPanel, "Login"));
        registerButton.addActionListener(e -> cardLayout.show(cardPanel, "Register"));
        searchButton.addActionListener(e -> cardLayout.show(cardPanel, "Search"));

        //로그인이 필요한 기능
        addLoginButton(borrowButton, "Borrow");
        addLoginButton(returnButton, "Return");
        addLoginButton(checkoutButton, "CheckOut");
        addLoginButton(requestButton, "Request");

        add(cardPanel);
        setVisible(true);
    }

    private JPanel createLoginPanel() {
        JPanel loginPanel = new JPanel();
        loginPanel.setLayout(new BorderLayout());
        loginPanel.setBorder(BorderFactory
                .createEmptyBorder(screenWidth / 4, screenWidth / 4, screenWidth / 4, screenWidth / 4));

        // 로그인 타이틀
        JLabel titleLabel = new JLabel("Sign In", SwingConstants.CENTER);
        titleLabel.setFont(new Font("Arial", Font.BOLD, 20));
        loginPanel.add(titleLabel, BorderLayout.NORTH);

        // ID와 Password 입력 필드
        JPanel fieldsPanel = new JPanel(new GridLayout(2, 2, 10, 10));
        JLabel idLabel = new JLabel("ID:");
        JTextField idField = new JTextField();
        JLabel passwordLabel = new JLabel("Password:");
        JPasswordField passwordField = new JPasswordField();
        fieldsPanel.add(idLabel);
        fieldsPanel.add(idField);
        fieldsPanel.add(passwordLabel);
        fieldsPanel.add(passwordField);
        loginPanel.add(fieldsPanel, BorderLayout.CENTER);

        // 로그인 및 취소 버튼
        JPanel buttonsPanel = new JPanel(new FlowLayout());
        JButton loginButton = new JButton("로그인");
        JButton cancelButton = new JButton("취소");
        buttonsPanel.add(loginButton);
        buttonsPanel.add(cancelButton);
        loginPanel.add(buttonsPanel, BorderLayout.SOUTH);

        // 이벤트 리스너 추가 (실제 로직은 controller를 통해 구현)
        loginButton.addActionListener(e -> {
            String id = idField.getText();
            String pw = new String(passwordField.getPassword());
            if (controller.login(id, pw)) {
                //성공 시의 메세지 출력
                JOptionPane.showMessageDialog(this, "Login successful!");
            } else {
                //실패 시의 메세지 출력
                JOptionPane.showMessageDialog(this, "Incorrect ID or password!");
            }
        });

        cancelButton.addActionListener(e -> {
            cardLayout.show(cardPanel, "Main Menu"); // 메인 메뉴로 돌아가기
        });

        return loginPanel;
    }

    private JPanel createRegisterPanel() {
        JPanel registerPanel = new JPanel();
        registerPanel.setLayout(new BorderLayout());
        registerPanel.setBorder(BorderFactory
                .createEmptyBorder(screenWidth / 4, screenWidth / 4, screenWidth / 4, screenWidth / 4));

        // 로그인 타이틀
        JLabel titleLabel = new JLabel("Sign Up", SwingConstants.CENTER);
        titleLabel.setFont(new Font("Arial", Font.BOLD, 20));
        registerPanel.add(titleLabel, BorderLayout.NORTH);

        // ID와 Password 입력 필드
        JPanel fieldsPanel = new JPanel(new GridLayout(2, 2, 10, 10));
        JLabel idLabel = new JLabel("ID:");
        JTextField idField = new JTextField();
        JLabel passwordLabel = new JLabel("Password:");
        JPasswordField passwordField = new JPasswordField();
        fieldsPanel.add(idLabel);
        fieldsPanel.add(idField);
        fieldsPanel.add(passwordLabel);
        fieldsPanel.add(passwordField);
        registerPanel.add(fieldsPanel, BorderLayout.CENTER);

        // 회원가입 및 취소 버튼
        JPanel buttonsPanel = new JPanel(new FlowLayout());
        JButton registerButton = new JButton("회원가입");
        JButton cancelButton = new JButton("취소");
        buttonsPanel.add(registerButton);
        buttonsPanel.add(cancelButton);
        registerPanel.add(buttonsPanel, BorderLayout.SOUTH);

        registerButton.addActionListener(e -> {
            String id = idField.getText();
            String pw = new String(passwordField.getPassword());
            int registerResult = controller.register(id, pw);
            switch (registerResult) {
                case 0:
                    // 성공 시의 메세지 출력
                    JOptionPane.showMessageDialog(this, "Register successful!");
                    break;
                case 1:
                    // 실패 시의 메세지 출력
                    JOptionPane.showMessageDialog(this, "The same ID or Password exists!");
                    break;
                default:
                    break;
            }

        });

        cancelButton.addActionListener(e -> {
            cardLayout.show(cardPanel, "Main Menu"); // 메인 메뉴로 돌아가기
        });

        return registerPanel;
    }

    // 샘플 데이터를 model에 추가하는 메서드
    /*private void addSampleData(DefaultTableModel model) {
        model.addRow(new Object[]{"978-0-13-468599-1", "Effective Java", "Joshua Bloch", "Addison-Wesley"});
        model.addRow(new Object[]{"978-0-59-600920-5", "Head First Java", "Kathy Sierra & Bert Bates", "O'Reilly Media"});
        model.addRow(new Object[]{"978-0-13-235088-4", "Clean Code", "Robert C. Martin", "Prentice Hall"});
        model.addRow(new Object[]{"978-1-491-94765-0", "Java Concurrency in Practice", "Brian Goetz", "Addison-Wesley"});
        model.addRow(new Object[]{"978-1-484-21242-9", "Spring in Action", "Craig Walls", "Manning Publications"});
        model.addRow(new Object[]{"978-1-593-27648-3", "Java: A Beginner's Guide", "Herbert Schildt", "McGraw-Hill Education"});
        model.addRow(new Object[]{"978-1-449-37641-9", "Java Performance", "Charlie Hunt & Binu John", "O'Reilly Media"});
        model.addRow(new Object[]{"978-0-321-34960-3", "Core Java Volume I", "Cay S. Horstmann", "Prentice Hall"});
        model.addRow(new Object[]{"978-0-13-417730-4", "Java 8 in Action", "Raoul-Gabriel Urma", "Manning Publications"});
        model.addRow(new Object[]{"978-1-118-95119-2", "Beginning Java 8 Fundamentals", "Kishori Sharan", "Wrox"});
    }
    // createSearchPanel 메서드 내에서 샘플 데이터 추가 호출
    private JPanel createSearchPanel() {
        JPanel searchPanel = new JPanel(new BorderLayout());
        JLabel searchLabel = new JLabel("도서명 검색");
        JTextField searchField = new JTextField(20);
        JButton searchButton = new JButton("검색");
        JButton cancelButton = new JButton("취소");

        JTable table = new JTable(controller.searchBookByName(""));
        JScrollPane scrollPane = new JScrollPane(table);

        // 검색 패널 상단에 라벨, 검색 필드, 검색 버튼, 취소 버튼 추가
        JPanel topPanel = new JPanel();
        topPanel.add(searchLabel);
        topPanel.add(searchField);
        topPanel.add(searchButton);
        topPanel.add(cancelButton);
        searchPanel.add(topPanel, BorderLayout.NORTH);

        // 테이블에 스크롤 패널 추가
        searchPanel.add(scrollPane, BorderLayout.CENTER);

        // 검색 버튼 이벤트 리스너
        searchButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                String bookName = searchField.getText().trim();

                //입력한 내용이 없을 때
                if (bookName.equals("")) {
                    //도서 내용 전체 보여주기
                    table.setModel(controller.searchBookByName(""));
                }
                //뭐라도 입력했을 때
                else {
                    //검색한 책이 있으면 검색한 책의 정보를 보여줌
                    if (controller.searchedBookExists(bookName)) {
                        table.setModel(controller.searchBookByName(bookName));
                    }
                    //없으면 메세지를 보여줌
                    else {
                        JOptionPane.showMessageDialog(createSearchPanel(), "No such book");
                    }
                }
            }
        });

        cancelButton.addActionListener(e -> {
            cardLayout.show(cardPanel, "Main Menu"); // 메인 메뉴로 돌아가기
        });

        return searchPanel;
    }


    private JPanel createBorrowPanel() {
        JPanel borrowPanel = new JPanel(new BorderLayout());
        JLabel borrowLabel = new JLabel("대출할 도서 입력");
        JTextField borrowField = new JTextField(20);
        JButton borrowButton = new JButton("대출");
        JButton cancelButton = new JButton("취소");

        // 검색 패널 상단에 라벨, 검색 필드, 검색 버튼, 취소 버튼 추가
        JPanel topPanel = new JPanel();
        topPanel.add(borrowLabel);
        topPanel.add(borrowField);
        topPanel.add(borrowButton);
        topPanel.add(cancelButton);
        borrowPanel.add(topPanel, BorderLayout.CENTER);

        borrowButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                String bookName = borrowField.getText().trim();

                //입력한 내용이 없을 때
                if (bookName.equals("")) {
                    JOptionPane.showMessageDialog(createSearchPanel(), "Input something");
                }
                //뭐라도 입력했을 때
                else {
                    //검색한 책이 있으면 검색한 책의 정보를 보여줌
                    if (controller.searchedBookExists(bookName)) {
                        controller.borrowBook(bookName);
                        JOptionPane.showMessageDialog(createSearchPanel(), "Borrowed");
                    }
                    //없으면 메세지를 보여줌
                    else {
                        JOptionPane.showMessageDialog(createSearchPanel(), "No such book");
                    }
                }
            }
        });

        cancelButton.addActionListener(e -> {
            cardLayout.show(cardPanel, "Main Menu"); // 메인 메뉴로 돌아가기
        });

        return borrowPanel;
    }

    private JPanel createReturnPanel() {
        JPanel returnPanel = new JPanel(new BorderLayout());
        JButton cancelButton;
        JLabel returnLabel = new JLabel("반납할 도서 입력");
        JTextField returnField = new JTextField(20);
        JButton returnButton = new JButton("반납");
        cancelButton = new JButton("취소");

        // 검색 패널 상단에 라벨, 검색 필드, 검색 버튼, 취소 버튼 추가
        JPanel topPanel = new JPanel();
        topPanel.add(returnLabel);
        topPanel.add(returnField);
        topPanel.add(returnButton);
        topPanel.add(cancelButton);
        returnPanel.add(topPanel, BorderLayout.CENTER);

        returnButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                String bookName = returnField.getText().trim();

                //입력한 내용이 없을 때
                if (bookName.equals("")) {
                    JOptionPane.showMessageDialog(createSearchPanel(), "Input something");
                }
                //뭐라도 입력했을 때
                else {
                    //검색한 책이 있으면 검색한 책의 정보를 보여줌
                    if (controller.searchedBookExists(bookName)) {
                        controller.returnBook(bookName);
                        JOptionPane.showMessageDialog(createSearchPanel(), "Returned");
                    }
                    //없으면 메세지를 보여줌
                    else {
                        JOptionPane.showMessageDialog(createSearchPanel(), "No such book");
                    }
                }
            }
        });

        cancelButton.addActionListener(e -> {
            cardLayout.show(cardPanel, "Main Menu"); // 메인 메뉴로 돌아가기
        });
        return returnPanel;
    }

    private JPanel createCheckoutPanel() {
        JPanel checkoutPanel = new JPanel(new BorderLayout());
        JButton cancelButton = new JButton("취소");

        JTable table = new JTable(controller.addBorrowedBookData());
        JScrollPane scrollPane = new JScrollPane(table);

        JPanel topPanel = new JPanel();
        topPanel.add(cancelButton);
        checkoutPanel.add(topPanel, BorderLayout.NORTH);

        // 테이블에 스크롤 패널 추가
        checkoutPanel.add(scrollPane, BorderLayout.CENTER);

        // 검색 버튼 이벤트 리스너
        cancelButton.addActionListener(e -> {
            cardLayout.show(cardPanel, "Main Menu"); // 메인 메뉴로 돌아가기
        });

        return checkoutPanel;
    }

    private JPanel createRequestPanel() {
        JPanel requestPanel = new JPanel();
        requestPanel.setLayout(new BorderLayout());
        requestPanel.setBorder(BorderFactory
                .createEmptyBorder(screenWidth / 4, screenWidth / 4, screenWidth / 4, screenWidth / 4));

        // 로그인 타이틀
        JLabel titleLabel = new JLabel("Book Request", SwingConstants.CENTER);
        titleLabel.setFont(new Font("Arial", Font.BOLD, 15));
        requestPanel.add(titleLabel, BorderLayout.NORTH);

        // ID와 Password 입력 필드
        JPanel fieldsPanel = new JPanel(new GridLayout(3, 2, 10, 10));
        JLabel bookLabel = new JLabel("Book Name:");
        JTextField bookField = new JTextField();
        JLabel authorLabel = new JLabel("Author:");
        JTextField authorField = new JTextField();
        JLabel publisherLabel = new JLabel("Publisher:");
        JTextField publisherField = new JTextField();
        fieldsPanel.add(bookLabel);
        fieldsPanel.add(bookField);
        fieldsPanel.add(authorLabel);
        fieldsPanel.add(authorField);
        fieldsPanel.add(publisherLabel);
        fieldsPanel.add(publisherField);
        requestPanel.add(fieldsPanel, BorderLayout.CENTER);

        // 회원가입 및 취소 버튼
        JPanel buttonsPanel = new JPanel(new FlowLayout());
        JButton requestButton = new JButton("Request");
        JButton cancelButton = new JButton("Cancel");
        buttonsPanel.add(requestButton);
        buttonsPanel.add(cancelButton);
        requestPanel.add(buttonsPanel, BorderLayout.SOUTH);

        requestButton.addActionListener(e -> {
            String book = bookField.getText();
            String author = authorField.getText();
            String publisher = publisherField.getText();
            int requestResult = controller.request(book, author, publisher);
            if (!book.equals("")) {
                switch (requestResult) {
                    case 0:
                        // 성공 시의 메세지 출력
                        JOptionPane.showMessageDialog(this, "Requested");
                        break;
                    case 1:
                        // 실패 시의 메세지 출력
                        JOptionPane.showMessageDialog(this, "Same book exists");
                        break;
                    default:
                        break;
                }
            } else {
                JOptionPane.showMessageDialog(this, "Input something");
            }
        });

        cancelButton.addActionListener(e -> {
            cardLayout.show(cardPanel, "Main Menu"); // 메인 메뉴로 돌아가기
        });
        return requestPanel;
    }

    //로그인 유저만 사용할 수 있는 버튼
    private void addLoginButton(JButton button, String panelName) {
        button.addActionListener(e -> {
            if (controller.isLoggedIn()) {
                cardLayout.show(cardPanel, panelName);
            } else {
                JOptionPane.showMessageDialog(this, "Login Please");
                cardLayout.show(cardPanel, "Main Menu");
            }
        });
    }

}*/



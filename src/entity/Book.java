// 작성자 : 김상규, 최연호

package entity;

public class Book {
    private String name;
    private String writer;
    private String publisher;
    private String date;
    private int num;

    public Book(String name, String writer, String publisher,  int num) {
        this.name      = name;
        this.writer    = writer;
        this.publisher = publisher;

        this.num       = num;
    }

    public String getName() {
        return name;
    }

    public String getWriter() {
        return writer;
    }

    public String getPublisher() {
        return publisher;
    }

    public String getDate() {
        return date;
    }

    public int getNum() {
        return num;
    }

}

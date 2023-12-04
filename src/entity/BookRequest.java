// 작성자 : 김상규, 최연호

package entity;

public class BookRequest {
    private String name;
    private String writer;
    private String publisher;
    private String requesterId;
    private Boolean accept;

    public BookRequest(String name, String writer, String publisher, String requesterId, Boolean accept) {
        this.name = name;
        this.writer = writer;
        this.publisher = publisher;
        this.requesterId = requesterId;
        this.accept = accept;
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

    public String getRequesterId() {
        return requesterId;
    }

    public Boolean getAccept() {
        return accept;
    }
}

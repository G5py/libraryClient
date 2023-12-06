// 작성자 : 김상규, 최연호

package entity;

public class BookRequest {
    private String name;
    private String writer;
    private String publisher;
    private String requesterId;
    private RequestState state = RequestState.WAITING;

    public BookRequest(String name, String writer, String publisher, String requesterId) {
        this.name = name;
        this.writer = writer;
        this.publisher = publisher;
        this.requesterId = requesterId;

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
    public RequestState getState() {
        return state;
    }
    public void setState(RequestState st){this.state =st;}

}


// 작성자 : 김상규

package repository;


// Repository들의 싱글톤 유지를 담당함.
public class RepositoryManager {
    private static BookHashmapRepository   bookRepository   = new BookHashmapRepository();
    private static MemberHashmapRepository memberRepository = new MemberHashmapRepository();


    public static BookHashmapRepository getBookHashmapRepository() {
        return bookRepository;
    }

    public static MemberHashmapRepository getMemberHashmapRepository() {
        return memberRepository;
    }

}

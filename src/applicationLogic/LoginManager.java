package applicationLogic;

import repository.MemberHashmapRepository;
import repository.RepositoryManager;

public class LoginManager {
    private MemberHashmapRepository memberRepository;

    public LoginManager() {
        this.memberRepository = RepositoryManager.getMemberHashmapRepository();
    }

    // 로그인 메소드
    public boolean login(String id, String pw) {
        boolean isLoginSuccess = memberRepository.checkCredentials(id, pw);
        return isLoginSuccess;
    }
}
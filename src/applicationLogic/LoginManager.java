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
    public boolean checkAuth(String id){
        return memberRepository.getAuth(id);
    }

    public void setAuth(String id, String code) {
        if(memberRepository.checkAuthCode(code)){
            memberRepository.setAuth(id,true);
            System.out.println("권한 관리자로 설정완료");
        }
        else
            System.out.println("권한 변경실패");

    }
}
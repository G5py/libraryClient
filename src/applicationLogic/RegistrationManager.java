package applicationLogic;

import repository.MemberHashmapRepository;
import repository.RepositoryManager;

public class RegistrationManager {
    private MemberHashmapRepository memberRepository;

    public RegistrationManager() {
        this.memberRepository = RepositoryManager.getMemberHashmapRepository();
    }

    // 사용자 등록 메소드
    public int register(String id, String pw) {
        // 아이디 중복 확인
        if (memberRepository.checkUsernameExists(id)) {
            return 1;  // 중복된 아이디가 이미 존재하는 경우
        }
        else
        {
            // 아이디 중복이 없는 경우, 사용자 등록
            memberRepository.addUser(id, pw);
            return 0;  // 등록 성공
        }
    }
}
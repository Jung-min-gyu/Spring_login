package hello.login.domain.login;

import hello.login.domain.member.Member;
import hello.login.domain.member.MemberRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class LoginService {

    private final MemberRepository memberRepository;

    /**
     *
     * @return null 이면 로그인 실패
     */
    public Member login(String loginId, String password) {
        return memberRepository.findByLonginId(loginId).   //아래 코드가 이렇게 간추려질 수 있기 때문에 자바 8 Optional Stream 꼭 공부해야한다!!
                filter(m -> m.getPassword().equals(password))
                .orElse(null);

//        memberRepository.findByLonginId(loginId)
//        Optional<Member> findMemberOptional = memberRepository.findByLonginId(loginId);
//        Member member = findMemberOptional.get();
//        if (member.getPassword().equals(password)) {
//            return member;
//        } else {
//            return null;
//        }

    }
}

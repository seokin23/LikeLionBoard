package myproject.likelionboard.domain.service;

import lombok.RequiredArgsConstructor;
import myproject.likelionboard.domain.entity.Member;
import myproject.likelionboard.domain.exception.LoginIdDuplication;
import myproject.likelionboard.domain.repository.member.SpringDataJpaMemberRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class MemberService {

    private final SpringDataJpaMemberRepository memberRepository;

    public  Member save(Member member){
        validateDuplicateLoginId(member);
        return memberRepository.save(member);
    }

    private void validateDuplicateLoginId(Member member) {
        memberRepository.findByLoginId(member.getLoginId()).ifPresent(m -> {throw new LoginIdDuplication("가입 ID 중복");});
    }

    public List<Member> findAll(){
        return memberRepository.findAll();
    }

    public Member findMemberById(Long id) {
        return memberRepository.findById(id).orElseThrow();
    }

    public List<Member> findAllMembers() {
        return memberRepository.findAll();
    }

    public void deleteMember(Long id) {
        memberRepository.deleteById(id);
    }

}

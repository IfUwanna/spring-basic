package hello.core.member;

/**
 * packageName    : hello.core.member
 * fileName       : MemberServiceImpl
 * author         : Jihun Park
 * date           : 2022/03/01
 * description    :
 * ===========================================================
 * DATE              AUTHOR             NOTE
 * -----------------------------------------------------------
 * 2022/03/01        Jihun Park       최초 생성
 */
public class MemberServiceImpl implements MemberService{

    private final MemberRepository memberRepository = new MemoryMemberRepository();//dip, ocp 위반

    @Override
    public void join(Member member) {
        memberRepository.save(member);
    }

    @Override
    public Member findMember(Long memberId) {
        return memberRepository.findById(memberId);
    }
}

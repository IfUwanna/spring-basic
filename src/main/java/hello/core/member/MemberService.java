package hello.core.member;

/**
 * packageName    : hello.core.member
 * fileName       : memberService
 * author         : Jihun Park
 * date           : 2022/03/01
 * description    :
 * ===========================================================
 * DATE              AUTHOR             NOTE
 * -----------------------------------------------------------
 * 2022/03/01        Jihun Park       최초 생성
 */
public interface MemberService {

    void join(Member member);

    Member findMember(Long memberId);

}

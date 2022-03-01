package hello.core.member;

/**
 * packageName    : hello.core.member
 * fileName       : MemberRepository
 * author         : Jihun Park
 * date           : 2022/03/01
 * description    :
 * ===========================================================
 * DATE              AUTHOR             NOTE
 * -----------------------------------------------------------
 * 2022/03/01        Jihun Park       최초 생성
 */
public interface MemberRepository {

    void save(Member member);

    Member findById(Long memberId);

}

package hello.core.member;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

/**
 * packageName    : hello.core.member
 * fileName       : MemberServiceTest
 * author         : Jihun Park
 * date           : 2022/03/01
 * description    :
 * ===========================================================
 * DATE              AUTHOR             NOTE
 * -----------------------------------------------------------
 * 2022/03/01        Jihun Park       최초 생성
 */
public class MemberServiceTest {

    MemberService memberService = new MemberServiceImpl();

    @Test
    void join(){
        //given
        Member member = new Member(1L,"memberA", Grade.VIP);

        //when
        memberService.join(member);
        Member findMember = memberService.findMember(1L);

        //then
        Assertions.assertThat(member).isEqualTo(findMember);
    }
}

package hello.core;

import hello.core.member.Grade;
import hello.core.member.Member;
import hello.core.member.MemberService;
import hello.core.member.MemberServiceImpl;

/**
 * packageName    : hello.core
 * fileName       : MemberApp
 * author         : Jihun Park
 * date           : 2022/03/01
 * description    :
 * ===========================================================
 * DATE              AUTHOR             NOTE
 * -----------------------------------------------------------
 * 2022/03/01        Jihun Park       최초 생성
 */
public class MemberApp {
    public static void main(String[] args) {
        AppConfig appConfig = new AppConfig();
        //MemberService memberService = new MemberServiceImpl();
        MemberService memberService = appConfig.memberService(); // 생성자 주입을 통한 인스턴스 생성
        Member member = new Member(1L, "memberA", Grade.VIP);
        memberService.join(member);

        Member findMember = memberService.findMember(1L);
        System.out.println("new member = " + member.getName());
        System.out.println("find Member = " + findMember.getName());
    }
}

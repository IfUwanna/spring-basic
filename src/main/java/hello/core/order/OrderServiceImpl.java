package hello.core.order;

import hello.core.discount.DiscountPolicy;
import hello.core.discount.FixDiscountPolicy;
import hello.core.discount.RateDiscountPolicy;
import hello.core.member.Member;
import hello.core.member.MemberRepository;
import hello.core.member.MemoryMemberRepository;

/**
 * packageName    : hello.core.order
 * fileName       : OrderServiceImpl
 * author         : Jihun Park
 * date           : 2022/03/01
 * description    :
 * ===========================================================
 * DATE              AUTHOR             NOTE
 * -----------------------------------------------------------
 * 2022/03/01        Jihun Park       최초 생성
 */
public class OrderServiceImpl implements OrderService {

    private final MemberRepository memberRepository;
    private final DiscountPolicy discountPolicy; // 인터페이스만 의존하게 변경 DIP! 그냥쓰면 NPE

    public OrderServiceImpl(MemberRepository memberRepository, DiscountPolicy discountPolicy) {
        this.memberRepository = memberRepository;
        this.discountPolicy = discountPolicy;
    }
/*
    private final DiscountPolicy discountPolicy = new RateDiscountPolicy();
    //private final DiscountPolicy discountPolicy = new FixDiscountPolicy();
    // 클라이언트인(서비스) 구현체에도 의존함!
    //DIP : 추상 인터페이스 DdiscountPolicy, 구현클래스 모두 의존 FixDiscountPolicy > 추상화에만 의존해야함!!
    //OCP : 구현체 수정을 위해 소스 바꿔줘야함!
*/


    @Override
    public Order createOrder(Long memberId, String itemName, int itemPrice) {
        Member member = memberRepository.findById(memberId);
        int discountPrice = discountPolicy.discount(member,itemPrice); //SRP 준수(할인 정책의 관심사 분리)

        return new Order(memberId,itemName,itemPrice,discountPrice);
    }

    //테스트 용도
    public MemberRepository getMemberRepository(){
        return memberRepository;
    }
}

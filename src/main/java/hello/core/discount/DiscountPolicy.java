package hello.core.discount;

import hello.core.member.Member;

/**
 * packageName    : hello.core.discount
 * fileName       : DiscountPolicy
 * author         : Jihun Park
 * date           : 2022/03/01
 * description    :
 * ===========================================================
 * DATE              AUTHOR             NOTE
 * -----------------------------------------------------------
 * 2022/03/01        Jihun Park       최초 생성
 */
public interface DiscountPolicy {

    /**
     * @return 할인대상 금액
     */
    int discount(Member member, int price);


}

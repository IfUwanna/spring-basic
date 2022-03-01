package hello.core.order;

/**
 * packageName    : hello.core.order
 * fileName       : OrderService
 * author         : Jihun Park
 * date           : 2022/03/01
 * description    :
 * ===========================================================
 * DATE              AUTHOR             NOTE
 * -----------------------------------------------------------
 * 2022/03/01        Jihun Park       최초 생성
 */
public interface OrderService {

    Order createOrder(Long memberId, String itemName, int itemPrice);

}

package hello.core.member;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/**
 * packageName    : hello.core.member
 * fileName       : MemoryMemberRepository
 * author         : Jihun Park
 * date           : 2022/03/01
 * description    :
 * ===========================================================
 * DATE              AUTHOR             NOTE
 * -----------------------------------------------------------
 * 2022/03/01        Jihun Park       최초 생성
 */
public class MemoryMemberRepository implements MemberRepository{

    private static Map<Long, Member> store = new ConcurrentHashMap<>();

    @Override
    public void save(Member member) {
        store.put(member.getId(),member);
    }

    @Override
    public Member findById(Long memberId) {
        return store.get(memberId);
    }
}

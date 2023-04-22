package hello.core.member;

import java.util.HashMap;
import java.util.Map;

public class MemoryMemberRepository implements  MemberRepository{

    // 동시성 이슈가 있을 수 있기에, ConcurrentHashMap 을 사용해야 하는데, 예제에선 간단히 해야하므로 생략함.
    private static Map<Long, Member> store = new HashMap<>();

    @Override
    public void save(Member member) {
        store.put(member.getId(), member);

    }

    @Override
    public Member findById(Long memberId) {
        return store.get(memberId);
    }
}

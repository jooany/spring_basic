package hello.core.order;

import hello.core.discount.DiscountPolicy;
import hello.core.discount.FixDiscountPolicy;
import hello.core.discount.RateDiscountPolicy;
import hello.core.member.Member;
import hello.core.member.MemberRepository;
import hello.core.member.MemoryMemberRepository;

public class OrderServiceImpl implements OrderService{

    private MemberRepository memberRepository = new MemoryMemberRepository();
//    private DiscountPolicy discountPolicy = new FixDiscountPolicy();
    private DiscountPolicy discountPolicy = new RateDiscountPolicy();

    // 할인 정책을 변경하려면 클라이언트인 OrderServiceImpl 의 코드를 변경해야 함.
    // 이는 추상 뿐만 아니라 구현 클래스에도 의존하고 있기 때문이다.
    // -> OCP, DIP 설계 원칙 위반

    // 이를 해결 하기 위해서는 추상만 의존해야 한다.
    // 클라이언트인 OrderServiceImpl에 DiscountPolicy 의 구현 객체를 대신 생성하고 주입하는 누군가가 필요하다.
//    private final DiscountPolicy discountPolicy;
    @Override
    public Order createOrder(Long memberId, String itemName, int itemPrice) {
        Member member = memberRepository.findById(memberId);
        return new Order(memberId, itemName, itemPrice, discountPolicy.discount(member, itemPrice));
    }
}

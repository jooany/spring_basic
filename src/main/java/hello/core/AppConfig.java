package hello.core;

import hello.core.discount.DiscountPolicy;
import hello.core.discount.FixDiscountPolicy;
import hello.core.member.MemberService;
import hello.core.member.MemberServiceImpl;
import hello.core.member.MemoryMemberRepository;
import hello.core.order.OrderService;
import hello.core.order.OrderServiceImpl;

/*
AppConfig는 애플리케이션의 실제 동작에 필요한 [구현 객체를 생성] 한다.
AppConfig는 생성한 객체 인스턴스의 참조를 생성자를 통해서 주입 한다.
이를 통해, 관심사를 확실하게 분리했다. Appconfig 가 구체 클래스를 선택하기 때문에 serviceImpl 들은 실행에만 집중할 수 있다.
 */
public class AppConfig {

    // 생성자 주입
//    public MemberService memberService(){
//        return new MemberServiceImpl(new MemoryMemberRepository());
//    }
//
//    public OrderService orderService(){
//        return new OrderServiceImpl(new MemoryMemberRepository(), new FixDiscountPolicy());
//    }

    // 위의 코드는 역할에 따른 구현이 잘 보이지 않으므로 아래와 같이 리팩토링했다.
    // 각 역할들과 역할에 따른 구현 클래스를 한 눈에 볼 수 있게 함으로, 애플리케이션 전체 구성을 빠르게 파악할 수 있다.
    public MemberService memberService(){
        return new MemberServiceImpl(memberRepository());
    }

    private MemoryMemberRepository memberRepository() {
        return new MemoryMemberRepository();
    }

    public OrderService orderService(){
        return new OrderServiceImpl(memberRepository(), discountPolicy());
    }

    public DiscountPolicy discountPolicy(){
        return new FixDiscountPolicy();
    }
}

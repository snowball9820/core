package hello.example.core;

import hello.example.core.discount.FixDiscountPolicy;
import hello.example.core.member.MemberService;
import hello.example.core.member.MemberServiceImpl;
import hello.example.core.member.MemoryMemberRepository;
import hello.example.core.order.OrderService;
import hello.example.core.order.OrderServiceImpl;

//앱 전반을 관리하는 기능을 가짐,시스템 환경 구성을 여기서 다함
public class AppConfig {

    //멤버 서비스
    public MemberService memberService() {
        return new MemberServiceImpl(new MemoryMemberRepository());//생성자를 통해 객체가 인스턴스 생성된 것이 들어간다고 해서 생성자 주입
    }

    //오더 서비스
    public OrderService orderService() {
        return new OrderServiceImpl(
                new MemoryMemberRepository(), //
                new FixDiscountPolicy());
    }

}

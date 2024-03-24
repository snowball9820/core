package hello.example.core;

import hello.example.core.discount.DiscountPolicy;
import hello.example.core.discount.FixDiscountPolicy;
import hello.example.core.member.MemberRepository;
import hello.example.core.member.MemberService;
import hello.example.core.member.MemberServiceImpl;
import hello.example.core.member.MemoryMemberRepository;
import hello.example.core.order.OrderService;
import hello.example.core.order.OrderServiceImpl;

//앱 전반을 관리하는 기능을 가짐,시스템 환경 구성을 여기서 다함
public class AppConfig {

    //멤버 서비스
    public MemberService memberService() {
        return new MemberServiceImpl(memberRepository());//생성자를 통해 객체가 인스턴스 생성된 것이 들어간다고 해서 생성자 주입
    }

    //멤버 repository, 역할들이 드러나게 Refactoring
    private static MemberRepository memberRepository() {
        return new MemoryMemberRepository(); //리포지토리는 MemoryMemberRepository를 쓸거다
    }

    //오더 서비스
    public OrderService orderService() {
        return new OrderServiceImpl(memberRepository(), discountPolicy());
    }

    public DiscountPolicy discountPolicy() {
        return new FixDiscountPolicy(); //FixDicountPolicy를 사용할거다
    }

}

//나중에 db나 할인정책 등이 바뀌면 여기서 바꾸면 됨
//new MemoryMemberRepository() 이 부분이 중복 제거되었다. 이제 MemoryMemberRepository 를
//다른 구현체로 변경할 때 한 부분만 변경하면 된다.
//AppConfig 를 보면 역할과 구현 클래스가 한눈에 들어온다. 애플리케이션 전체 구성이 어떻게 되어있는지 빠르
//게 파악할 수 있다
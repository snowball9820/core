package hello.example.core.order;


import hello.example.core.discount.DiscountPolicy;
import hello.example.core.member.Member;
import hello.example.core.member.MemberRepository;


public class OrderServiceImpl implements OrderService {
    //    private final MemberRepository memberRepository=new MemoryMemberRepository();
    //현재 구체적인것에도 의존, 추상적인 것에도 의존, DIP위반
//    private final DiscountPolicy discountPolicy = new FixDiscountPolicy();
//    private final DiscountPolicy discountPolicy = new RateDiscountPolicy(); //할인 정책을 바꾸는데 OrderServiceImpl을 수정하게 됨
    //그래서 이렇게 수정함
    //근데 DIP를 지켰더니 NullPointerException

    //이제 구체적은 클래스에 대해서는 전혀 모르고 인터페이스에만 의존하여 DIP를 지키고 있음
    private final MemberRepository memberRepository;
    private final DiscountPolicy discountPolicy;
    /*
    * 객체의 생성과 연결은 AppConfig가 담당
    * MemberServiceImpl은 MemberRepository인 추상에만 의존, 이제 구체 클래스는 몰라도 됨
    * 객체를 생성하고 연결하는 역할이 명확하게 분리됨
    * */

    public OrderServiceImpl(MemberRepository memberRepository, DiscountPolicy discountPolicy) {
        this.memberRepository = memberRepository;
        this.discountPolicy = discountPolicy;
    }

    //주문 생성 요청이 오면, 회원 조회를 하고, 할인 정책에 회원을 넘겨줌
    //
    @Override
    public Order createOrder(Long memberId, String itemName, int itemPrice) {
        Member member = memberRepository.findById(memberId);
        int discountPrice = discountPolicy.discount(member, itemPrice); //단일책임원칙 잘 지킴

        return new Order(memberId, itemName, itemPrice, discountPrice);
    }
}

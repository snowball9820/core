package hello.example.core.order;


import hello.example.core.discount.DiscountPolicy;
import hello.example.core.discount.FixDiscountPolicy;
import hello.example.core.member.Member;
import hello.example.core.member.MemberRepository;
import hello.example.core.member.MemoryMemberRepository;


public class OrderServiceImpl implements OrderService{
    private final MemberRepository memberRepository=new MemoryMemberRepository();
    //현재 구체적인것에도 의존, 추상적인 것에도 의존, DIP위반
//    private final DiscountPolicy discountPolicy = new FixDiscountPolicy();
//    private final DiscountPolicy discountPolicy = new RateDiscountPolicy(); //할인 정책을 바꾸는데 OrderServiceImpl을 수정하게 됨
    //그래서 이렇게 수정함
    private DiscountPolicy discountPolicy;

    //주문 생성 요청이 오면, 회원 조회를 하고, 할인 정책에 회원을 넘겨줌
    //
    @Override
    public Order createOrder(Long memberId, String itemName, int itemPrice) {
        Member member=memberRepository.findById(memberId);
        int discountPrice = discountPolicy.discount(member, itemPrice); //단일책임원칙 잘 지킴

        return new Order(memberId, itemName, itemPrice, discountPrice);
    }
}

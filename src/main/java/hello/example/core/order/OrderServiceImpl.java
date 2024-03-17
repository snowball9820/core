package hello.example.core.order;


import hello.example.core.discount.DiscountPolicy;
import hello.example.core.discount.FixDiscountPolicy;
import hello.example.core.member.Member;
import hello.example.core.member.MemberRepository;
import hello.example.core.member.MemoryMemberRepository;


public class OrderServiceImpl implements OrderService{
    private final MemberRepository memberRepository=new MemoryMemberRepository();
    private final DiscountPolicy discountPolicy = new FixDiscountPolicy();

    //주문 생성 요청이 오면, 회원 조회를 하고, 할인 정책에 회원을 넘겨줌
    //
    @Override
    public Order createOrder(Long memberId, String itemName, int itemPrice) {
        Member member=memberRepository.findById(memberId);
        int discountPrice = discountPolicy.discount(member, itemPrice); //단일책임원칙 잘 지킴

        return new Order(memberId, itemName, itemPrice, discountPrice);
    }
}

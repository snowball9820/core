package hello.example.core.order;

import hello.example.core.member.Grade;
import hello.example.core.member.Member;
import hello.example.core.member.MemberService;
import hello.example.core.member.MemberServiceImpl;

public class OrderApp
{
    public static void main(String[] args) {
        MemberService memberService = new MemberServiceImpl(memberRepository);
        OrderService orderService = new OrderServiceImpl(memberRepository, discountPolicy);

        Long memberId=1L;
        Member member = new Member(memberId, "memberA", Grade.VIP);
        memberService.join(member);

        Order order = orderService.createOrder(memberId, "itemA", 10000);

        System.out.println("order = " + order);
        //10000-1000=9000
        System.out.println("order.calculatePrice() = " + order.calculatePrice());
    }
}

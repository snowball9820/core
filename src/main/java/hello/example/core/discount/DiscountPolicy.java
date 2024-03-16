package hello.example.core.discount;

import hello.example.core.member.Member;

public interface DiscountPolicy {
    //return 할인 대상 금액 -> ex)천원이 할인됐어 라는 걸 리턴해줌
    int discount(Member member, int price);
}

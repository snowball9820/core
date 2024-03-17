package hello.example.core.discount;

import hello.example.core.member.Grade;
import hello.example.core.member.Member;

public class FixDiscountPolicy implements DiscountPolicy{

    private int discountFixAmount=1000; //1000원 할인


    @Override
    public int discount(Member member, int price) {
        if(member.getGrade()== Grade.VIP){ //enum타입은 ==
            return discountFixAmount;
        }else {
            return 0;
        }
    }
}

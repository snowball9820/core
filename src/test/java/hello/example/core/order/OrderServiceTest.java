package hello.example.core.order;

import hello.example.core.AppConfig;
import hello.example.core.member.Grade;
import hello.example.core.member.Member;
import hello.example.core.member.MemberService;
import hello.example.core.member.MemberServiceImpl;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class OrderServiceTest {
    MemberService memberService;
    OrderService orderService;
    @BeforeEach
    public void beforeEach(){
        AppConfig appConfig= new AppConfig();
        memberService = appConfig.memberService();
        orderService = appConfig.orderService();
    } //AppConfig를 먼저 만들고 memberService,orderService를 할당해줌

    @Test
    void createOrder() {
        Long memberId=1L; //프리미티드 타입 long으로 선언하면 null을 넣을 수가 없음 Long 사용(래퍼타입) 프리미티드 타입 써도 되긴 하는데 DB에 넣으면서 null이 들어갈 수 있으니 Long으로
        Member member = new Member(memberId, "memberA", Grade.VIP);
        memberService.join(member);

        Order order = orderService.createOrder(memberId, "itemA", 10000);
        Assertions.assertThat(order.getDiscountPrice()).isEqualTo(1000);


    }
}

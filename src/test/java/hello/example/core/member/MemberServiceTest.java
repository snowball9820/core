package hello.example.core.member;

import hello.example.core.AppConfig;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class MemberServiceTest {

    //test
    MemberService memberService;
    //test 실행전 무조건 실행
    @BeforeEach
    public void beforeEach(){
        AppConfig appConfig= new AppConfig();
        memberService = appConfig.memberService();
    } //AppConfig를 먼저 만들고 memberService를 할당해줌
    @Test
    void join() {
        //given
        Member member = new Member(1L, "memberA", Grade.VIP);
        //when
        memberService.join(member);
        Member findMember = memberService.findMember(1L);
        //then 검증
        Assertions.assertThat(member).isEqualTo(findMember);

    }
}

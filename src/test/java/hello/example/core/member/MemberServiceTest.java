package hello.example.core.member;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

public class MemberServiceTest {

    //test
    MemberService memberService = new MemberServiceImpl(memberRepository);
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

package hello.example.core.member;

public class MemberServiceImpl implements MemberService {
    //    private final MemberRepository memberRepository = new MemoryMemberRepository(); //추상화,구체화에도 의존 완전 안좋음 DIP위반
    private final MemberRepository memberRepository; //이제 MemberRepository라는 인터페이스만 있음, 추상화에만 의존하는 코드로 변경

    //생성자를 통해서 memberRepository에 어떤게 들어갈 것인지
    public MemberServiceImpl(MemberRepository memberRepository) {
        this.memberRepository = memberRepository;
    }

    public void join(Member member) {
        memberRepository.save(member);
    }

    public Member findMember(Long memberId) {
        return memberRepository.findById(memberId);
    }
}
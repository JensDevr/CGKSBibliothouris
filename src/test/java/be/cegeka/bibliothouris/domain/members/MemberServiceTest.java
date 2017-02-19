package be.cegeka.bibliothouris.domain.members;

import org.assertj.core.api.Assertions;
import org.junit.Rule;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnit;
import org.mockito.junit.MockitoRule;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.junit.Assert.*;
import static org.mockito.Mockito.never;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

/**
 * Created by jensde on 19/02/2017.
 */
public class MemberServiceTest {
    @Rule
    public MockitoRule rule = MockitoJUnit.rule();
    @InjectMocks
    private MemberService memberService;
    @Mock
    private MemberRepository memberRepository;

    @Test
    public void addMember_ShouldAddMember() throws Exception {
        String name = "Jens";
        String inss = "8";

        memberService.addMember(name, inss);
        Member member = new Member(name, inss);
        verify(memberRepository).addMember(member);
    }

    @Test
    public void addMember_NonUniqueINSS_ShouldNotAddMember(){
        String name = "Jens";
        String inss = "8";

        when(memberRepository.inssExists(inss)).thenReturn(true);
        memberService.addMember(name, inss);
        verify(memberRepository, never()).addMember(Mockito.any(Member.class));
    }

    @Test
    public void getAllMembers_ShouldReturnAllMembers() throws Exception {
        Member member1 = new Member("Jens", "8");
        Member member2 = new Member("Seppe", "9");

        when(memberRepository.getAllMembers()).thenReturn(Arrays.asList(member1,member2));
        List<Member> actual = memberService.getAllMembers();

        Assertions.assertThat(actual).containsOnly(member1, member2);

    }
}
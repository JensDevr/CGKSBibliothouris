package be.cegeka.bibliothouris.domain.members;

import javax.inject.Inject;
import javax.inject.Named;
import java.util.List;

/**
 * Created by jensde on 19/02/2017.
 */
@Named
public class MemberService {
    @Inject
    private MemberRepository memberRepository;

    public void addMember(String name, String inss) {
        if(!memberRepository.inssExists(inss)) {
            memberRepository.addMember(new Member(name, inss));
        }
    }


    public List<Member> getAllMembers() {
        return memberRepository.getAllMembers();
    }
}

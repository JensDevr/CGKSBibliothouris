package be.cegeka.bibliothouris.domain.members;

import javax.inject.Named;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by jensde on 19/02/2017.
 */
@Named
public class MemberRepository {

    private List<Member> members = new ArrayList<>();

    public void addMember(Member member) {
        members.add(member);
    }
    public boolean inssExists(String inss){
       return members.stream().anyMatch(member -> inss.equals(member.getInss()));
    }

    public List<Member> getAllMembers() {
        return members;
    }
}

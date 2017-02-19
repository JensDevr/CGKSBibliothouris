package be.cegeka.bibliothouris.application;

import be.cegeka.bibliothouris.domain.members.Member;
import be.cegeka.bibliothouris.domain.members.MemberService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.inject.Inject;
import java.util.List;

/**
 * Created by jensde on 19/02/2017.
 */
@Controller
@RequestMapping("/member")
public class MemberController {
    @Inject
    private MemberService memberService;

    @RequestMapping(method = RequestMethod.POST)
    public
    @ResponseBody
    void addMember(@RequestParam(value = "name", required = true) String name,
                   @RequestParam(value = "inss", required = true) String inss){
        memberService.addMember(name, inss);
    }

    @RequestMapping(method = RequestMethod.GET)
    public
    @ResponseBody
    List<Member> getAllMembers(){
       return memberService.getAllMembers();
    }
}

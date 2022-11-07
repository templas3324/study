package pref.study.domain.member.dto.response;

import lombok.Data;
import pref.study.domain.member.entity.Member;

@Data
public class MemberResponse {

    private String name;
    private String email;

    public MemberResponse(Member member){
        this.name = member.getName();
        this.email = member.getEmail();
    }
}

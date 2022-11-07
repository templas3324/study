package pref.study.domain.member.entity;

import lombok.Getter;
import pref.study.domain.member.dto.request.MemberSignUpRequest;

import java.time.LocalDateTime;

@Getter
public class Member {

    private Long memberId;

    private String name;
    private String email;
    private String nickname;
    private String password;

    private LocalDateTime joinedAt;

    private Boolean active;


    public Member(MemberSignUpRequest request){
        this.name = request.getName();
        this.email = request.getEmail();
        this.nickname = request.getNickname();
        this.password = request.getPassword();

    }

    public void completeSignUp(Long memberId){
        setMemberId(memberId);
        this.joinedAt = LocalDateTime.now();
        this.active = true;
    };


    private void setMemberId(Long memberSequence){
        this.memberId = memberSequence;
    };

}

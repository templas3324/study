package pref.study.domain.member.service;

import org.springframework.stereotype.Service;
import pref.study.domain.member.dto.response.MemberListResponse;
import pref.study.domain.member.dto.response.MemberResponse;
import pref.study.domain.member.dto.request.MemberSignUpRequest;
import pref.study.domain.member.entity.Member;

import java.util.ArrayList;
import java.util.List;

@Service
public class MemberService {

    // component 어노테이션을 사용해도 됨
    // 빈에 등록되기 위함

    List<Member> memberList = new ArrayList<>();
    Long memberSequence = 1L;


    public List<Member> getAll(){
        return memberList;
    }

    public MemberListResponse getAllMemberResponse(){
        List<MemberResponse> memberResponseList = new ArrayList<>();
        for (Member member : memberList) {
            memberResponseList.add(new MemberResponse(member));
        }
        return new MemberListResponse(memberResponseList.size(), memberResponseList);
    }

    public Member saveNewMember(MemberSignUpRequest request){
        Member member = new Member(request);
        member.completeSignUp(memberSequence++);
        memberList.add(member);
        return member;
    }

    public MemberResponse memberResponseAfterSignUp(MemberSignUpRequest request){
        return new MemberResponse(saveNewMember(request));
    }


    public MemberListResponse modifyMember() {
        return null;
    }
}

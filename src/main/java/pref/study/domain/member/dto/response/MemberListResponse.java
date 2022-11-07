package pref.study.domain.member.dto.response;

import lombok.Data;

import java.util.List;

@Data
public class MemberListResponse {
    private int memberCount;
    private List<MemberResponse> memberList;

    public MemberListResponse(int memberCount, List<MemberResponse> memberList){
        this.memberCount = memberCount;
        this.memberList = memberList;
    }
}

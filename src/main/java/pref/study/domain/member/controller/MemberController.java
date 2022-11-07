package pref.study.domain.member.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import pref.study.domain.member.dto.response.MemberListResponse;
import pref.study.domain.member.dto.response.MemberResponse;
import pref.study.domain.member.dto.request.MemberSignUpRequest;
import pref.study.domain.member.service.MemberService;
import pref.study.global.common.CommonResponse;

import javax.validation.Valid;

@RestController
@RequiredArgsConstructor
public class MemberController {

    private final MemberService memberService;

    @PostMapping(value = "/sign-up")
    public ResponseEntity<CommonResponse> singUpProcess(@Valid @RequestBody MemberSignUpRequest request, BindingResult errors){
        CommonResponse response;
        if (errors.hasErrors()){
            response = new CommonResponse(false, errors);
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(response);
        }
        MemberResponse result= memberService.memberResponseAfterSignUp(request);
        response = new CommonResponse(true, result);
        return ResponseEntity.status(HttpStatus.OK).body(response);
    }

    @GetMapping(value = "/member-list")
    public ResponseEntity<CommonResponse> memberList(){
        MemberListResponse result = memberService.getAllMemberResponse();
        CommonResponse response = new CommonResponse(true, result);
        return ResponseEntity.status(HttpStatus.OK).body(response);
    }
}

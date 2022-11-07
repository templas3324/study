package pref.study.domain.member.dto.request;

import lombok.Data;
import org.hibernate.validator.constraints.Length;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import java.lang.annotation.Native;

@Data
public class MemberSignUpRequest {

    @NotBlank
    @Length(min = 2, max = 10, message = "2글자 ~ 10글자 입력하세요.")
    private String name;

    @NotBlank(message = "빈칸 안돼요.")
    @Email(message = "이메일로 쓰세요.")
    private String email;

    @NotBlank
    @Length(min = 2, max = 10)
    private String nickname;

    @NotBlank
    private String password;

}

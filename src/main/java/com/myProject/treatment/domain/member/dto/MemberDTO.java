package com.myProject.treatment.domain.member.dto;

import com.myProject.treatment.domain.treatment.Treatment;
import jakarta.validation.constraints.NotEmpty;
import lombok.Getter;
import lombok.Setter;

import java.beans.ConstructorProperties;

@Getter @Setter
public class MemberDTO {
    @NotEmpty(message = "회원 아이디는 필수 입니다.")
    private String memberId;
    private String memberPwd;

    @NotEmpty(message = "회원 이름은 필수 입니다.")
    private String memberName;
    private String memberPhone;
    private String address;

    private Treatment treatment;

    public MemberDTO() {}

    @ConstructorProperties({"memberId", "memberPwd", "memberName", "memberPhone", "address"})
    public MemberDTO(String memberId, String memberPwd, String memberName, String memberPhone, String address) {
        this.memberId = memberId;
        this.memberPwd = memberPwd;
        this.memberName = memberName;
        this.memberPhone = memberPhone;
        this.address = address;
    }
}

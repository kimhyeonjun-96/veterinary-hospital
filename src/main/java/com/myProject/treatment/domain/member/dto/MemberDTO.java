package com.myProject.treatment.domain.member.dto;

import com.myProject.treatment.domain.treatment.dto.TreatmentDTO;
import jakarta.validation.constraints.NotEmpty;
import lombok.Getter;

@Getter
public class MemberDTO {

    private Long id;
    @NotEmpty(message = "회원 아이디는 필수 입니다.")
    private String memberId;
    private String memberPwd;
    @NotEmpty(message = "회원 이름은 필수 입니다.")
    private String memberName;
    private String memberPhone;
    private String address;
    private TreatmentDTO treatmentDTO;

    public MemberDTO() {}

    public MemberDTO(String memberId, String memberPwd, String memberName, String memberPhone, String address) {
        this.memberId = memberId;
        this.memberPwd = memberPwd;
        this.memberName = memberName;
        this.memberPhone = memberPhone;
        this.address = address;
    }

    public MemberDTO(Long id, String memberId, String memberPwd, String memberName, String memberPhone, String address) {
        this.id = id;
        this.memberId = memberId;
        this.memberPwd = memberPwd;
        this.memberName = memberName;
        this.memberPhone = memberPhone;
        this.address = address;
    }
}

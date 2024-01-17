package com.myProject.treatment.domain.user.domain;

import com.myProject.treatment.domain.treatment.domain.Treatment;
import jakarta.persistence.*;

public class MemberDTO {
    private Long ID;
    private String MemberId;
    private String MemberPwd;
    private String MemberName;
    private String MemberPhone;
    private String Address;
    private Treatment treatment;


    public Long getID() {
        return ID;
    }

    public String getMemberId() {
        return MemberId;
    }

    public String getMemberPwd() {
        return MemberPwd;
    }

    public String getMemberName() {
        return MemberName;
    }

    public String getMemberPhone() {
        return MemberPhone;
    }

    public String getAddress() {
        return Address;
    }

}

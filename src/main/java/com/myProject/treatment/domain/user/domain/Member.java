package com.myProject.treatment.domain.user.domain;

import com.myProject.treatment.domain.treatment.domain.Treatment;
import jakarta.persistence.*;

@Entity
public class Member {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long ID;


    private String MemberId;
    private String MemberPwd;
    private String MemberName;
    private String MemberPhone;
    private String Address;
    @ManyToOne
    @JoinColumn(name = "treatment_id")
    private Treatment treatment;


    public Member() {}
    public Member(String memberId, String memberPwd, String memberName, String memberPhone, String address) {
        MemberId = memberId;
        MemberPwd = memberPwd;
        MemberName = memberName;
        MemberPhone = memberPhone;
        Address = address;
    }


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

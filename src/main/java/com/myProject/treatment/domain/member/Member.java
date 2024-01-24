package com.myProject.treatment.domain.member;

import com.myProject.treatment.domain.treatment.Treatment;
import jakarta.persistence.*;
import lombok.Getter;

import java.util.List;

@Entity
@Table(name = "member")
@Getter
public class Member {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "member_id")
    private String memberId;
    @Column(name = "member_pwd")
    private String memberPwd;
    @Column(name = "member_name")
    private String memberName;
    @Column(name = "member_phone")
    private String memberPhone;
    @Column(name = "address")
    private String address;

    private Long treatmentId;

    public Member() {}

    public Member(String memberPwd, String memberPhone, String address) {
        this.memberPwd = memberPwd;
        this.memberPhone = memberPhone;
        this.address = address;
    }

    public Member(String memberId, String memberPwd, String memberName, String memberPhone, String address) {
        this.memberId = memberId;
        this.memberPwd = memberPwd;
        this.memberName = memberName;
        this.memberPhone = memberPhone;
        this.address = address;
    }

    // 회원 비밀번호 변경
    public void updateMemberPassword(String password){
        this.memberPwd = password;
    }
    // 회원 전화번호 변경
    public void updateMemberPhone(String phone){
        this.memberPhone = phone;
    }
    // 회원 주소 변경
    public void updateMemberAddress(String address){
        this.address = address;
    }

}

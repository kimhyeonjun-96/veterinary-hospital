package com.myProject.treatment.domain.member;

import com.myProject.treatment.domain.treatment.Treatment;
import jakarta.persistence.*;

@Entity
@Table(name = "member")
public class MemberDTO {
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

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "treatment_id")
    private Treatment treatment;


    public MemberDTO() {}
    public MemberDTO(String memberId, String memberPwd, String memberName, String memberPhone, String address) {
        this.memberId = memberId;
        this.memberPwd = memberPwd;
        this.memberName = memberName;
        this.memberPhone = memberPhone;
        this.address = address;
    }

    public Long getId() {
        return this.id;
    }

    public String getMemberId() {
        return this.memberId;
    }

    public String getMemberPwd() {
        return this.memberPwd;
    }

    public String getMemberName() {
        return this.memberName;
    }

    public String getMemberPhone() {
        return this.memberPhone;
    }

    public String getAddress() {
        return this.address;
    }

}

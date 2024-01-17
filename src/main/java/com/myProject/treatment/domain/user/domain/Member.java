package com.myProject.treatment.domain.user.domain;

import com.myProject.treatment.domain.treatment.domain.Treatment;
import jakarta.persistence.*;

@Entity
@Table(name = "member")
public class Member {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long ID;

    @Column(name = "member_id")
    private String member_id;
    @Column(name = "member_pwd")
    private String member_pwd;
    @Column(name = "member_name")
    private String member_name;
    @Column(name = "member_phone")
    private String member_phone;
    @Column(name = "address")
    private String Address;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "treatment_id")
    private Treatment treatment;


    public Member() {}
    public Member(String memberid, String memberpwd, String membername, String memberphone, String address) {
        member_id = memberid;
        member_pwd = memberpwd;
        member_name = membername;
        member_phone = memberphone;
        Address = address;
    }


    public Long getID() {
        return ID;
    }

    public String getMember_id() {
        return member_id;
    }

    public String getMember_pwd() {
        return member_pwd;
    }

    public String getMember_name() {
        return member_name;
    }

    public String getMember_phone() {
        return member_phone;
    }

    public String getAddress() {
        return Address;
    }

}

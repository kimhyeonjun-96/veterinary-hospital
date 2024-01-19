package com.myProject.treatment.domain.member;

import com.myProject.treatment.domain.treatment.Treatment;
import jakarta.persistence.*;

@Entity
@Table(name = "member")
public class Member {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "member_id")
    private String member_id;
    @Column(name = "member_pwd")
    private String member_pwd;
    @Column(name = "member_name")
    private String member_name;
    @Column(name = "member_phone")
    private String member_phone;
    @Column(name = "address")
    private String address;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "treatment_id")
    private Treatment treatment;


    public Member() {}
    public Member(String memberid, String memberpwd, String membername, String memberphone, String address) {
        this.member_id = memberid;
        this.member_pwd = memberpwd;
        this.member_name = membername;
        this.member_phone = memberphone;
        this.address = address;
    }

    public Long getId() {
        return this.id;
    }

    public String getMember_id() {
        return this.member_id;
    }

    public String getMember_pwd() {
        return this.member_pwd;
    }

    public String getMember_name() {
        return this.member_name;
    }

    public String getMember_phone() {
        return this.member_phone;
    }

    public String getAddress() {
        return this.address;
    }

}

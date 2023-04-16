package com.rainbowsweet.lastdance.entity;

import com.rainbowsweet.lastdance.Enum.MembershipGrade;
import com.rainbowsweet.lastdance.Enum.MembershipLevel;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table
public class Membership {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Enumerated(EnumType.STRING)
    private MembershipGrade grade;


    @Temporal(TemporalType.TIMESTAMP)
    private Date joinDate;

    @Temporal(TemporalType.TIMESTAMP)
    private Date expireDate;

    @OneToOne
    @JoinColumn(name = "member_id")
    private Member member;





    //getter, setter

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }


    public Date getJoinDate() {
        return joinDate;
    }

    public void setJoinDate(Date joinDate) {
        this.joinDate = joinDate;
    }

    public Date getExpireDate() {
        return expireDate;
    }

    public void setExpireDate(Date expireDate) {
        this.expireDate = expireDate;
    }


    public MembershipGrade getGrade() {
        return grade;
    }

    public void setGrade(MembershipGrade grade) {
        this.grade = grade;
    }

    public Member getMember() {
        return member;
    }

    public void setMember(Member member) {
        this.member = member;
    }

}

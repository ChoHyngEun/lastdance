package com.rainbowsweet.lastdance.Enum;

public enum MembershipGrade {
    BASIC("기본 회원"),
    SILVER("실버 회원"),
    GOLD("골드 회원"),
    VIP("VIP 회원");

    private String name;

    MembershipGrade(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }
}

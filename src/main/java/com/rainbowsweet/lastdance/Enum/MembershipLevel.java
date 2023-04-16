package com.rainbowsweet.lastdance.Enum;

public enum MembershipLevel {
    Lv1(1, 100, "새싹 레벨"),
    Lv2(2, 200, "초급자 레벨"),
    Lv3(3, 300, "중급자 레벨"),
    Lv4(4, 400, "고급자 레벨"),
    Lv5(5, 500, "개발자 레벨"),
    Lv6(6, 600, "마스터 레벨");

    private final int level;
    private final int requiredExp;
    private final String name;


    MembershipLevel(int level, int requiredExp, String name) {
        this.level = level;
        this.requiredExp = requiredExp;
        this.name = name;
    }
    public String getName() {
        return this.name;
    }

    public int getRequiredExpForNextLevel() {
        return this.requiredExp;
    }

    public MembershipLevel nextLevel() {
        return this.ordinal() < MembershipLevel.values().length - 1 ? MembershipLevel.values()[this.ordinal() + 1] : null;
    }
}

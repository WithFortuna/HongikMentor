package com.hongik.mentor.hongik_mentor.domain;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter @RequiredArgsConstructor
public enum Role {
    ADMIN("ROLE_ADMIN", "관리자"),GUEST("ROLE_GUEST","게스트"), USER("ROLE_USER", "일반 사용자")
    ,TEMP("ROLE_TEMP", "임시 사용자");

    private final String key;
    private final String title;
}

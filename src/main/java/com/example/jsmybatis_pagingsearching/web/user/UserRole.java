package com.example.jsmybatis_pagingsearching.web.user;

import lombok.Getter;

@Getter
public enum UserRole {
    COMMON("Common"),
    ADMIN("Admin"),
    VIP("VIP");

    private final String displayName;

    UserRole(String displayName) {
        this.displayName = displayName;
    }

    public String getDisplayName() {
        return displayName;
    }
}

package com.myProject.treatment.domain.member.controller;

public record MemberCommonResponse(
        String Status,
        String message,
        Object data
) {}

package com.auth.store.entity.dto;

public record LoginDto(
    String usernameOrEmail,
    String password
) {
}

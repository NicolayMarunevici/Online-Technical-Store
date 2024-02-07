package com.auth.store.service;

import com.auth.store.entity.dto.LoginDto;
import com.auth.store.entity.dto.RegisterDto;

public interface AuthService {
  String login(LoginDto loginDto);

  String register(RegisterDto registerDto);
}

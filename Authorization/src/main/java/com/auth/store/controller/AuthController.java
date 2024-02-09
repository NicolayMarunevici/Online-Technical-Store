package com.auth.store.controller;

import com.auth.store.entity.dto.JwtAuthResponse;
import com.auth.store.entity.dto.LoginDto;
import com.auth.store.entity.dto.RegisterDto;
import com.auth.store.service.AuthService;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("api/auth")
public class AuthController {

  private final AuthService authService;

  public AuthController(AuthService authService) {
    this.authService = authService;
  }

  //Build Login REST API
  @PostMapping(value = {"/login", "/signin"})
  public JwtAuthResponse login(@RequestBody LoginDto loginDto) {
    String token = authService.login(loginDto);

    JwtAuthResponse jwtAuthResponse = new JwtAuthResponse();
    jwtAuthResponse.setAccessToken(token);

    return jwtAuthResponse;
  }

  // Build Register REST API
  @PostMapping(value = {"/register", "/signup"})
  @ResponseStatus(HttpStatus.CREATED)
  public String register(@RequestBody RegisterDto registerDto) {
    return authService.register(registerDto);
  }
}

package com.auth.store.service.impl;

import com.auth.store.entity.Role;
import com.auth.store.entity.User;
import com.auth.store.entity.dto.LoginDto;
import com.auth.store.entity.dto.RegisterDto;
import com.auth.store.exception.UserNotFoundException;
import com.auth.store.repository.RoleRepository;
import com.auth.store.repository.UserRepository;
import com.auth.store.security.JwtTokenProvider;
import com.auth.store.service.AuthService;
import java.util.HashSet;
import java.util.Set;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
@Slf4j
public class AuthServiceImpl implements AuthService {
  private final AuthenticationManager authenticationManager;
  private final UserRepository userRepository;
  private final RoleRepository roleRepository;
  private final PasswordEncoder passwordEncoder;
  private final JwtTokenProvider jwtTokenProvider;

  public AuthServiceImpl(AuthenticationManager authenticationManager, UserRepository userRepository,
                         RoleRepository roleRepository, PasswordEncoder passwordEncoder,
                         JwtTokenProvider jwtTokenProvider) {
    this.authenticationManager = authenticationManager;
    this.userRepository = userRepository;
    this.roleRepository = roleRepository;
    this.passwordEncoder = passwordEncoder;
    this.jwtTokenProvider = jwtTokenProvider;
  }

  // Method, which allows to authenticate user
  @Override
  public String login(LoginDto loginDto) {
    log.info("Attempt to authorize user ");
    Authentication authentication =
        authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(
            loginDto.usernameOrEmail(), loginDto.password()));

    SecurityContextHolder.getContext().setAuthentication(authentication);

    String token = jwtTokenProvider.generateToken(authentication);
    log.info("User is authorized");
    return token;
  }

  @Override
  public String register(RegisterDto registerDto) {
    if (userRepository.existsUserByUsername(registerDto.username())) {
      throw new UserNotFoundException(
          "User with such username already exists", HttpStatus.BAD_REQUEST);
    } else if (userRepository.existsUserByEmail(registerDto.email())) {
      throw new UserNotFoundException(
          "User with such email already exists", HttpStatus.BAD_REQUEST);
    } else {
      Set<Role> roles = new HashSet<>();
      String userRole = "ROLE_USER";
      roles.add(roleRepository.findByName(userRole).orElseThrow(
          () -> new UserNotFoundException(
              String.format("Role %s does not exist in database", userRole),
              HttpStatus.BAD_REQUEST)));
      User newUser =
          new User(registerDto.username(), passwordEncoder.encode(registerDto.password()),
              registerDto.email(), roles);
      userRepository.save(newUser);
      return "User has been created";
    }
  }
}

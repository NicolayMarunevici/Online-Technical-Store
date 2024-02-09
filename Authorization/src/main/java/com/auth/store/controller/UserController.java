package com.auth.store.controller;

import com.auth.store.entity.User;
import com.auth.store.service.UserService;
import java.util.List;
import lombok.RequiredArgsConstructor;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping("api/v1")
public class UserController {
  private final UserService userService;


  @PreAuthorize("hasRole('ADMIN')")
  @GetMapping
  public List<User> getAll() {
    return userService.getAll();
  }

  @PreAuthorize(value = "{hasRole('USER'), hasRole('ADMIN')}")
  @GetMapping("/{id}")
  public User getById(@PathVariable long id) {
    return userService.getById(id);
  }

  @PreAuthorize("hasRole('ADMIN')")
  @PostMapping
  public User create(@RequestBody User user) {
    return userService.create(user);
  }
}

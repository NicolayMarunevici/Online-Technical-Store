package com.technical.store.online.technical.store.controller;

import com.technical.store.online.technical.store.dto.UserDto;
import com.technical.store.online.technical.store.entity.User;
import com.technical.store.online.technical.store.service.UserService;
import java.util.List;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("api/v1")
public class UserController {

  private UserService userService;

  public UserController(UserService userService) {
    this.userService = userService;
  }


  @GetMapping("users")
  public List<User> getAll(){
    return userService.getAll();
  }

  @PostMapping("user")
  public String create(@RequestBody UserDto userDto){
    return userService.create(userDto);
  }

}

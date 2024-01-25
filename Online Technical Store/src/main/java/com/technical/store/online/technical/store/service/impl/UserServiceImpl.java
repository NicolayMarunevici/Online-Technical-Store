package com.technical.store.online.technical.store.service.impl;

import com.technical.store.online.technical.store.dto.UserDto;
import com.technical.store.online.technical.store.entity.User;
import com.technical.store.online.technical.store.mapper.UserMapper;
import com.technical.store.online.technical.store.repository.UserRepository;
import com.technical.store.online.technical.store.service.UserService;
import java.util.Date;
import java.util.List;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {

  private UserRepository userRepository;

  public UserServiceImpl(UserRepository userRepository) {
    this.userRepository = userRepository;
  }

  public List<User> getAll(){
    return userRepository.findAll();
  }

  public String create(UserDto userDto) {
    User newUser = UserMapper.INSTANCE.mapToUser(userDto);
    Date date = new Date();
    newUser.setCreatedAt(date);
    userRepository.save(newUser);
    return String.format("User %s was saved successfully", newUser.getUsername());
  }
}

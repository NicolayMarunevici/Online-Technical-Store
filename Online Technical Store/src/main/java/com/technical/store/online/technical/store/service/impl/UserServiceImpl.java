package com.technical.store.online.technical.store.service.impl;

import com.technical.store.online.technical.store.dto.UserDto;
import com.technical.store.online.technical.store.mapper.UserMapper;
import com.technical.store.online.technical.store.repository.UserRepository;
import com.technical.store.online.technical.store.service.UserService;
import java.util.Date;
import java.util.List;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {

  private final UserRepository userRepository;

  public UserServiceImpl(UserRepository userRepository) {
    this.userRepository = userRepository;
  }

  @Override
  public List<UserDto> getAll(){
    return UserMapper.INSTANCE.mapToUserDtoList(userRepository.findAll());
  }

  @Override
  public String create(UserDto userDto) {
    userDto.setCreatedAt(new Date());
    userRepository.save(UserMapper.INSTANCE.mapToUser(userDto));
    return String.format("User %s was saved successfully", userDto.getUsername());
  }
}

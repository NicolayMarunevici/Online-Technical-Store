package com.technical.store.online.technical.store.service;

import com.technical.store.online.technical.store.dto.UserDto;
import com.technical.store.online.technical.store.mapper.UserMapper;
import com.technical.store.online.technical.store.repository.UserRepository;
import java.util.Date;
import java.util.List;
import org.springframework.stereotype.Service;

@Service
public class UserService {

  private final UserRepository userRepository;

  public UserService(UserRepository userRepository) {
    this.userRepository = userRepository;
  }

  public List<UserDto> getAll(){
    return UserMapper.INSTANCE.mapToUserDtoList(userRepository.findAll());
  }

  public String create(UserDto userDto) {
    userDto.setCreatedAt(new Date());
    userRepository.save(UserMapper.INSTANCE.mapToUser(userDto));
    return String.format("User %s was saved successfully", userDto.getUsername());
  }
}

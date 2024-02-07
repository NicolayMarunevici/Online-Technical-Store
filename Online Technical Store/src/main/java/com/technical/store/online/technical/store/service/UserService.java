package com.technical.store.online.technical.store.service;

import com.technical.store.online.technical.store.dto.UserDto;
import java.util.List;

public interface UserService {

  List<UserDto> getAll();

  String create(UserDto userDto);
}

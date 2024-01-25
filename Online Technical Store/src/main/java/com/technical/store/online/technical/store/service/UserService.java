package com.technical.store.online.technical.store.service;

import com.technical.store.online.technical.store.dto.UserDto;
import com.technical.store.online.technical.store.entity.User;
import java.util.List;
import org.springframework.stereotype.Service;

public interface UserService {

  List<User> getAll();

  String create(UserDto userDto);
}

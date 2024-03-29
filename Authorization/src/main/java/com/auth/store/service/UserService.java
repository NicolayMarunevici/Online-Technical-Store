package com.auth.store.service;

import com.auth.store.entity.User;
import com.auth.store.exception.UserNotFoundException;
import com.auth.store.repository.UserRepository;
import java.util.List;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
@Slf4j
public class UserService {
  private final UserRepository userRepository;

  public List<User> getAll() {
    log.info("Get All Users");
    return userRepository.findAll();
  }

  public User getById(long id) {
    log.info("Find User By Id");
    return userRepository.findById(id)
        .orElseThrow(() -> new UserNotFoundException("User with id " + id + " does not exist",
            HttpStatus.NOT_FOUND));
  }

  public User create(User user) {
    log.info("Create User");
    return userRepository.save(user);
  }
}






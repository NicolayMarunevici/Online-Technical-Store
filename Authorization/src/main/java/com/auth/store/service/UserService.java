package com.auth.store.service;

import com.auth.store.entity.User;
import java.util.List;
import org.springframework.stereotype.Service;

@Service
public interface UserService {

  List<User> getAll();

  User getById(long id);

  User create(User user);
}

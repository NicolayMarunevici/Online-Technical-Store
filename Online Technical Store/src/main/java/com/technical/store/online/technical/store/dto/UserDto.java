package com.technical.store.online.technical.store.dto;

import java.util.Date;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class UserDto {
  private String username;
  private String password;
  private String firstName;
  private String lastName;
  private String address;
  private String phone;
  private Date createdAt;
  private Date updatedAt;
}

package com.technical.store.online.technical.store.dto;

import java.util.Date;
import lombok.Data;
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
  private Integer phone;
  private Date createdAt;
  private Date updatedAt;
}

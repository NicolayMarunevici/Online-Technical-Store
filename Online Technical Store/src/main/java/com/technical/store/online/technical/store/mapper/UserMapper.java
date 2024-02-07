package com.technical.store.online.technical.store.mapper;

import com.technical.store.online.technical.store.dto.UserDto;
import com.technical.store.online.technical.store.entity.User;
import java.util.List;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public interface UserMapper {
  UserMapper INSTANCE = Mappers.getMapper(UserMapper.class);

  List<UserDto> mapToUserDtoList(List<User> userList);
  UserDto mapToUserDto(User user);

  User mapToUser(UserDto userDto);

}

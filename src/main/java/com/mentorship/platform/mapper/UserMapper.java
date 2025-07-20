package com.mentorship.platform.mapper;

import com.mentorship.platform.model.User;
import com.mentorship.platform.dto.UserDTO;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface UserMapper {
    UserDTO toDTO(User user);
    User toEntity(UserDTO dto);
}
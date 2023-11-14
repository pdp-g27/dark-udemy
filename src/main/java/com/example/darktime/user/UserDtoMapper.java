package com.example.darktime.user;

import com.example.darktime.common.service.GenericDtoMapper;
import com.example.darktime.user.dto.UserCreateDto;
import com.example.darktime.user.dto.UserResponseDto;
import com.example.darktime.user.dto.UserUpdateDto;
import com.example.darktime.user.entity.User;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

import java.util.UUID;

@Component
@RequiredArgsConstructor
public class UserDtoMapper extends GenericDtoMapper<User, UUID, UserCreateDto, UserUpdateDto, UserResponseDto> {

    private final ModelMapper mapper;

    @Override
    public User toEntity(UserCreateDto userCreateDto) {
        return mapper.map(userCreateDto, User.class);
    }

    @Override
    public UserResponseDto toResponseDto(User user) {
        return mapper.map(user, UserResponseDto.class);
    }

    @Override
    public void update(UserUpdateDto userUpdateDto, User user) {
        mapper.map(userUpdateDto, user);
    }
}

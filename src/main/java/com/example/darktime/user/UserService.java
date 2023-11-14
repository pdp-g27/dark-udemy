package com.example.darktime.user;

import com.example.darktime.common.service.GenericCrudService;
import com.example.darktime.user.dto.UserCreateDto;
import com.example.darktime.user.dto.UserResponseDto;
import com.example.darktime.user.dto.UserUpdateDto;
import com.example.darktime.user.entity.User;
import jakarta.transaction.Transactional;
import lombok.AllArgsConstructor;
import lombok.Getter;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
@AllArgsConstructor
@Transactional
@Getter
public class UserService extends GenericCrudService<User, UUID, UserCreateDto, UserUpdateDto, UserResponseDto> {

    private final UserDtoMapper mapper;
    private final UserRepository repository;
}

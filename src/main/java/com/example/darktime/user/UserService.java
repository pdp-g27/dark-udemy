package com.example.darktime.user;

import com.example.darktime.user.dto.UserCreateDto;
import com.example.darktime.user.dto.UserResponseDto;
import com.example.darktime.user.dto.UserUpdateDto;
import com.example.darktime.user.entity.User;
import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
@RequiredArgsConstructor
public class UserService {

    private final UserRepository userRepository;
    public User save(UserCreateDto userCreateDto) {
        User user = User.builder()
                .id(UUID.randomUUID())
                .email(userCreateDto.getEmail())
                .phoneNumber(userCreateDto.getPhoneNumber())
                .lastName(userCreateDto.getLastName())
                .middleName(userCreateDto.getMiddleName())
                .userType(userCreateDto.getUserType())
                .firstName(userCreateDto.getFirstName())
                .password(userCreateDto.getPassword())
                .firstName(userCreateDto.getFirstName())
                .build();
    return     userRepository.save(user);
    }

    public User findById(UUID id) {
        return userRepository.findById(id).orElseThrow(() -> new EntityNotFoundException("User with id: " + id + " not found"));
    }

    public List<User> getAll() {
        return userRepository.findAll();
    }

    public UserResponseDto update(UUID id, UserUpdateDto userUpdateDto, ModelMapper modelMapper) {
        User user = userRepository.findById(id).orElseThrow(() -> new EntityNotFoundException("Not Found"));
        modelMapper.map(userUpdateDto,user);
       return modelMapper.map(userRepository.save(user),UserResponseDto.class);
    }

    public void delete(UUID id) {
        userRepository.deleteById(id);
    }
}

package com.example.darktime.user;

import com.example.darktime.user.dto.UserCreateDto;
import com.example.darktime.user.dto.UserResponseDto;
import com.example.darktime.user.dto.UserUpdateDto;
import com.example.darktime.user.entity.User;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;

import org.modelmapper.ModelMapper;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequiredArgsConstructor
@RequestMapping("/user")
public class UserController {

    private final UserService userService;
    @PostMapping
    @Transactional
    public ResponseEntity<UserResponseDto>create(@RequestBody UserCreateDto userCreateDto, ModelMapper modelMapper){
        User user = userService.save(userCreateDto);
        UserResponseDto map = modelMapper.map(user, UserResponseDto.class);
        return ResponseEntity.ok(map);
    }

    @GetMapping("/{id}")
    @Transactional
    public ResponseEntity<UserResponseDto>getUserById(@PathVariable("id")UUID id,ModelMapper modelMapper){
        User user = userService.findById(id);
        UserResponseDto map = modelMapper.map(user, UserResponseDto.class);
        return ResponseEntity.ok(map);
    }


    @GetMapping
    @Transactional
    public ResponseEntity<List<UserResponseDto>>getAllUser(ModelMapper modelMapper){
        List<UserResponseDto> list = userService.getAll().stream().map(user -> modelMapper.map(user, UserResponseDto.class)).toList();
        return ResponseEntity.ok(list);
    }

    @Transactional
    @PutMapping("/{id}")
    public ResponseEntity<UserResponseDto>update(@PathVariable("id")UUID id , @RequestBody UserUpdateDto userUpdateDto, ModelMapper modelMapper){
        UserResponseDto update = userService.update(id, userUpdateDto, modelMapper);
        return ResponseEntity.ok(update);
    }

    @Transactional
    @DeleteMapping("/{id}")
    public void delete(@PathVariable ("id") UUID id){
        userService.delete(id);
    }
}

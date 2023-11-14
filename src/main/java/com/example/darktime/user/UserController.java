package com.example.darktime.user;


import com.example.darktime.user.dto.UserCreateDto;
import com.example.darktime.user.dto.UserResponseDto;
import com.example.darktime.user.dto.UserUpdateDto;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

@RestController
@RequestMapping("/user")
@RequiredArgsConstructor
public class UserController {

    private final UserService userService;

    @PostMapping
    public ResponseEntity<UserResponseDto> createUser(@RequestBody UserCreateDto userCreateDto) {
        UserResponseDto userResponseDto = userService.create(userCreateDto);
        return ResponseEntity.ok(userResponseDto);
    }


    @GetMapping
    public ResponseEntity<Page<UserResponseDto>> getAllUsers(Pageable pageable,
                                                             @RequestParam(required = false) String predicate) {

        Page<UserResponseDto> responseDto = userService.getAll(pageable, predicate);
        return ResponseEntity.ok(responseDto);
    }

    @GetMapping("/{id}")
    public ResponseEntity<UserResponseDto> getUser(@PathVariable UUID id) {

        UserResponseDto byId = userService.getById(id);
        return ResponseEntity.ok(byId);
    }

    @PutMapping("/{id}")
    public ResponseEntity<UserResponseDto> updateUser(@PathVariable UUID id, @RequestBody UserUpdateDto updateDto) {

        UserResponseDto update = userService.update(id, updateDto);
        return ResponseEntity.ok(update);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> delete(@PathVariable UUID id) {
        userService.delete(id);
        return ResponseEntity.ok("deleted");
    }


}

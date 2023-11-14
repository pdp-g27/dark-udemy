package com.example.darktime.group;

import com.example.darktime.group.dto.GroupCreateDto;
import com.example.darktime.group.dto.GroupResponseDto;
import com.example.darktime.group.dto.GroupUpdateDto;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/group")
@RequiredArgsConstructor
public class GroupController {
    private final GroupService groupService;

    @PostMapping
    public ResponseEntity<GroupResponseDto> createUser(@RequestBody GroupCreateDto createDto) {
        GroupResponseDto responseDto = groupService.create(createDto);
        return ResponseEntity.ok(responseDto);
    }

    @GetMapping
    public ResponseEntity<Page<GroupResponseDto>> getUsers(Pageable pageable, @RequestParam(required = false) String predicate) {
        Page<GroupResponseDto> responseDto = groupService.getAll(pageable, predicate);
        return ResponseEntity.ok(responseDto);
    }

    @GetMapping("/{id}")
    public ResponseEntity<GroupResponseDto> getUser(@PathVariable UUID id) {
        GroupResponseDto responseDto = groupService.getById(id);
        return ResponseEntity.ok(responseDto);
    }

    @PutMapping("/{id}")
    public ResponseEntity<GroupResponseDto> updateUser(@PathVariable UUID id, @RequestBody GroupUpdateDto updateDto) {
        GroupResponseDto responseDto = groupService.update(id, updateDto);
        return ResponseEntity.ok(responseDto);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteUser(@PathVariable UUID id) {
        groupService.delete(id);
        return ResponseEntity.ok("DELETED");
    }
}

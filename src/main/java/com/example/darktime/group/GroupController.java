package com.example.darktime.group;

import com.example.darktime.group.dto.GroupCreateDto;
import com.example.darktime.group.dto.GroupRequestDto;
import com.example.darktime.group.dto.GroupResponseDto;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@Controller
@RequestMapping("/group")
@RequiredArgsConstructor
public class GroupController {
    private final GroupService groupService;
    @PostMapping
    public GroupResponseDto create(@RequestBody GroupCreateDto groupCreateDto){
        return groupService.create(groupCreateDto);
    }
    @GetMapping
    public List<GroupResponseDto> getAll(){
        return groupService.getAll();
    }
    @GetMapping("/{groupId}")
    public GroupResponseDto get(@PathVariable("groupId") UUID uuid){
        return groupService.get(uuid);
    }
    @DeleteMapping("/{groupId}")
    public GroupResponseDto delete(@PathVariable("groupId") UUID uuid){
        return groupService.delete(uuid);
    }
    @PutMapping("/{groupId}")
    public GroupResponseDto update(@PathVariable UUID groupId,
                                   @RequestBody GroupRequestDto groupRequestDto){
        return groupService.update(groupId,groupRequestDto);
    }
}

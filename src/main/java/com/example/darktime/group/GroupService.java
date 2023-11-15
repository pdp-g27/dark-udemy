package com.example.darktime.group;

import com.example.darktime.group.dto.GroupCreateDto;
import com.example.darktime.group.dto.GroupResponseDto;
import com.example.darktime.group.dto.GroupUpdateDto;
import com.example.darktime.group.entity.Group;
import com.example.darktime.common.service.GenericCrudService;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Getter
@Service
@RequiredArgsConstructor
public class GroupService extends GenericCrudService<Group, UUID, GroupCreateDto, GroupUpdateDto, GroupResponseDto> {
    private final GroupMapperDto mapper;
    private final GroupRepository repository;
}

package com.example.darktime.group;

import com.example.darktime.group.dto.GroupCreateDto;
import com.example.darktime.group.dto.GroupResponseDto;
import com.example.darktime.group.dto.GroupUpdateDto;
import com.example.darktime.group.entity.Group;
import com.example.darktime.common.service.GenericDtoMapper;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

@RequiredArgsConstructor
@Component
public class GroupMapperDto extends GenericDtoMapper<Group, GroupCreateDto, GroupUpdateDto, GroupResponseDto> {
    private final ModelMapper mapper;

    @Override
    public Group toEntity(GroupCreateDto groupCreateDto) {
        return mapper.map(groupCreateDto, Group.class);
    }

    @Override
    public GroupResponseDto toResponseDto(Group group) {
        return mapper.map(group, GroupResponseDto.class);
    }

    @Override
    public void update(GroupUpdateDto groupUpdateDto, Group group) {
        mapper.map(groupUpdateDto, group);
    }
}

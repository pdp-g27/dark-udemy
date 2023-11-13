package com.example.darktime.group;

import com.example.darktime.group.dto.GroupCreateDto;
import com.example.darktime.group.dto.GroupRequestDto;
import com.example.darktime.group.dto.GroupResponseDto;
import com.example.darktime.group.entity.Group;
import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
@RequiredArgsConstructor
public class GroupService {
    private final GroupRepository groupRepository;

    public GroupResponseDto create(GroupCreateDto groupCreateDto) {
        Group group = new Group();
        group.setName(groupCreateDto.getName());

        groupRepository.save(group);

        return new GroupResponseDto(group.getUuid(), group.getName());
    }

    public List<GroupResponseDto> getAll() {
        List<Group> all = groupRepository.findAll();
        return all
                .stream()
                .map(group -> new GroupResponseDto(group.getUuid(), group.getName()))
                .toList();

    }

    public GroupResponseDto get(UUID groupId) {
        Group group = groupRepository.findById(groupId).get();

        return new GroupResponseDto(group.getUuid(), group.getName());
    }


    public GroupResponseDto delete(UUID groupId) {
        groupRepository.deleteById(groupId);
        return null;
    }

    public GroupResponseDto update(UUID id, GroupRequestDto requestDto, ModelMapper modelMapper) {

        Group group = groupRepository.findById(id).orElseThrow(() -> new EntityNotFoundException("Not Found"));
        modelMapper.map(requestDto, group);
        return modelMapper.map(groupRepository.save(group), GroupResponseDto.class);


    }
}

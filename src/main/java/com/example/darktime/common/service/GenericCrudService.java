package com.example.darktime.common.service;

import com.example.darktime.common.repository.GenericSpecificationRepository;
import com.example.darktime.common.rsql.SpecificationBuilder;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.domain.Specification;

public abstract class GenericCrudService<ENTITY, ID, CREATE_DTO, UPDATE_DTO, RESPONSE_DTO> {
    protected abstract GenericSpecificationRepository<ENTITY, ID> getRepository();

    protected abstract GenericDtoMapper<ENTITY, CREATE_DTO, UPDATE_DTO, RESPONSE_DTO> getMapper();

    public RESPONSE_DTO create(CREATE_DTO createDto) {
        ENTITY entity = getMapper().toEntity(createDto);
        ENTITY saved = getRepository().save(entity);
        return getMapper().toResponseDto(saved);
    }

    public Page<RESPONSE_DTO> getAll(Pageable pageable, String predicate) {
        Specification<ENTITY> specification = SpecificationBuilder.build(predicate);
        if (specification == null) {
            return getRepository().findAll(pageable)
                    .map(entity -> getMapper().toResponseDto(entity));
        }
        return getRepository().findAll(specification, pageable)
                .map(entity -> getMapper().toResponseDto(entity));
    }

    public RESPONSE_DTO getById(ID id) {
        // todo handle exceptions correctly
        ENTITY entity = getRepository().findById(id).orElseThrow();
        return getMapper().toResponseDto(entity);
    }

    public RESPONSE_DTO update(ID id, UPDATE_DTO updateDto) {
        ENTITY entity = getRepository().findById(id).orElseThrow();
        getMapper().update(updateDto, entity);
        ENTITY saved = getRepository().save(entity);
        return getMapper().toResponseDto(saved);
    }

    public void delete(ID id) {
        getRepository().deleteById(id);
    }
}
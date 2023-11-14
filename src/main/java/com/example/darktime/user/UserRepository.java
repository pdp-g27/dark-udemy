package com.example.darktime.user;

import com.example.darktime.common.repository.GenericSpecificationRepository;
import com.example.darktime.user.entity.User;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface UserRepository extends GenericSpecificationRepository<User, UUID> {

}

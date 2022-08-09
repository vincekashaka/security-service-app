package com.vince.userservice.repo;

import com.vince.userservice.model.UserRole;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRoleRepo extends JpaRepository<UserRole, Long> {
    UserRole findByName(String name);
}

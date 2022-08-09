package com.vince.userservice.service;

import com.vince.userservice.model.AppUser;
import com.vince.userservice.model.UserRole;

import java.util.List;

public interface UserService {
    AppUser saveUser(AppUser appUser);
    UserRole saveRole(UserRole userRole);

    void addRoleToUser(String username, String roleName);
    AppUser getUser(String username);

    List<AppUser> getUser();
}

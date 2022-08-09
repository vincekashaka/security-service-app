package com.vince.userservice.service;

import com.vince.userservice.model.AppUser;
import com.vince.userservice.model.UserRole;
import com.vince.userservice.repo.UserRepo;
import com.vince.userservice.repo.UserRoleRepo;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;


@Service
@RequiredArgsConstructor
@Transactional
@Slf4j
public class AppUserServiceImpl implements UserService{

    private final  UserRepo userRepo;
    private final UserRoleRepo userRoleRepo;

    @Override
    public AppUser saveUser(AppUser appUser) {
        log.info("Saving new user {} to the database", appUser.getName());
        return userRepo.save(appUser);
    }

    @Override
    public UserRole saveRole(UserRole userRole) {
        log.info("Saving new role {} to the database", userRole.getName());
        return userRoleRepo.save(userRole);
    }

    @Override
    public void addRoleToUser(String username, String roleName) {
        log.info("Adding role {} to user {}", roleName, username);
        AppUser appUser = userRepo.findByUsername(username);
        UserRole userRole = userRoleRepo.findByName(roleName);
        appUser.getUserRoles().add(userRole);
    }

    @Override
    public AppUser getUser(String username) {
        log.info("Fetching to user {}", username);
        return userRepo.findByUsername(username);
    }

    @Override
    public List<AppUser> getUser() {
        log.info("Fetching all users ");

        return userRepo.findAll();
    }
}

package com.jwt.auth.jwt.service;

import com.jwt.auth.jwt.entities.AppRole;
import com.jwt.auth.jwt.entities.AppUser;

import java.util.List;

public interface AccountService {

    AppUser addNewUser(AppUser appUser);
    AppRole addNewRole(AppRole appRole);
    void addRoleToUser(String username,String roleName);
    AppUser loadUserByUsername(String username);
    List<AppUser> listUsers();
}

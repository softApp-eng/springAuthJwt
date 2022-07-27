package com.jwt.auth.jwt.repositories;

import com.jwt.auth.jwt.entities.AppUser;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AppUserRepository extends JpaRepository<AppUser,Long> {

    AppUser findByUsername(String username);
}

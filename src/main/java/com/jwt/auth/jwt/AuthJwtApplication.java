package com.jwt.auth.jwt;

import com.jwt.auth.jwt.entities.AppRole;
import com.jwt.auth.jwt.entities.AppUser;
import com.jwt.auth.jwt.service.AccountService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

import java.util.ArrayList;

@SpringBootApplication
public class AuthJwtApplication {

    public static void main(String[] args) {
        SpringApplication.run(AuthJwtApplication.class, args);
    }
    @Bean
     PasswordEncoder passwordEncoder(){

        return new BCryptPasswordEncoder();
     }
    @Bean
    CommandLineRunner start(AccountService accountService) {
        return args -> {
            accountService.addNewRole(new AppRole(null, "USER"));
            accountService.addNewRole(new AppRole(null, "ADMIN"));
            accountService.addNewRole(new AppRole(null, "CUSTOMER_MANAGER"));
            accountService.addNewRole(new AppRole(null, "PRODUCT_MANAGER"));
            accountService.addNewRole(new AppRole(null, "BILLS_MANAGER"));

            accountService.addNewUser(new AppUser(null,"admin","123456",new ArrayList<>()));
            accountService.addNewUser(new AppUser(null,"user1","123456",new ArrayList<>()));
            accountService.addNewUser(new AppUser(null,"user2","123456",new ArrayList<>()));
            accountService.addNewUser(new AppUser(null,"user3","123456",new ArrayList<>()));
            accountService.addNewUser(new AppUser(null,"user4","123456",new ArrayList<>()));

            accountService.addRoleToUser("user1","USER");
            accountService.addRoleToUser("admin","ADMIN");
            accountService.addRoleToUser("admin","USER");
            accountService.addRoleToUser("user2","USER");
            accountService.addRoleToUser("user2","CUSTOMER_MANAGER");
            accountService.addRoleToUser("user3","USER");

            accountService.addRoleToUser("user3","PRODUCT_MANAGER");
            accountService.addRoleToUser("user4","USER");
            accountService.addRoleToUser("user4","BILLS_MANAGER");
        };
    }
}

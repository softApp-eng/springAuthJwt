package com.jwt.auth.jwt.web;

import com.jwt.auth.jwt.entities.AppRole;
import com.jwt.auth.jwt.entities.AppUser;
import com.jwt.auth.jwt.service.AccountService;
import lombok.Data;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class AccountRestController {
    private AccountService accountService;

    public AccountRestController(AccountService accountService) {
        this.accountService = accountService;
    }

    @GetMapping("/users")
    public List<AppUser> appUsers() {
        return accountService.listUsers();
    }

    @PostMapping(path = "/users")
    public AppUser saveUser(@RequestBody AppUser appUser) {
        return accountService.addNewUser(appUser);
    }
    @PostMapping(path = "/roles")
    public AppRole saveUser(@RequestBody AppRole appRole) {
        return accountService.addNewRole(appRole);
    }
    @PostMapping(path = "/addRoleToUser")
    public void saveUser(@RequestBody FormData formData) {
         accountService.addRoleToUser(formData.getUsername(),formData.getRoleName());
    }
}
@Data
class FormData{
    String username;
    String roleName;
}

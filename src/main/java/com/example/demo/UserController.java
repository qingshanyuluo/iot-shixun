package com.example.demo;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.*;

import java.util.Set;

@RestController
@RequestMapping
public class UserController {

    @Value("${shixun.admin.name}")
    private String adminUsername;

    @Value("${shixun.admin.password}")
    private String adminPassword;

    @PostMapping("admin")
    public boolean admin(@RequestParam("username") String username,
                         @RequestParam("password") String password) {
        return username.equals(adminUsername) && password.equals(adminPassword);
    }

    @GetMapping("users")
    public Set<String> users() {
        return UserData.getAll();
    }

    @DeleteMapping("user/{username}")
    public boolean delete(@PathVariable("username") String username) {
        UserData.delete(username);
        return true;
    }

    @PostMapping("login")
    public boolean login(@RequestParam("username") String username,
                         @RequestParam("password") String password) {
        try {
            return UserData.login(username, password);
        } catch (Exception e) {
            return false;
        }
    }

    @PostMapping("register")
    public boolean register(@RequestParam("username") String username,
                         @RequestParam("password") String password) {
        return UserData.register(username, password);
    }
}

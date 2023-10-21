package com.example.flightmanagement.services;


import com.example.flightmanagement.entities.User;
import org.springframework.cloud.openfeign.FeignClient;
        import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;

@FeignClient(name = "nodejs-service", url = "http://localhost:9000")
public interface userService {
    @GetMapping(value = "/user/user/{userId}", produces = "application/json")
    public User getUserById( @PathVariable String userId);
    @GetMapping("/users")
    public List<User> getAllUsers();






}

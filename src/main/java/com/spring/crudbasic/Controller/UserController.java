package com.spring.crudbasic.Controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.spring.crudbasic.Entity.User;
import com.spring.crudbasic.Service.UserService;

import jakarta.websocket.server.PathParam;

import org.springframework.web.bind.annotation.RequestMapping;






@RestController
@RequestMapping("/User")
public class UserController {
                  
    @Autowired
    UserService userService;
    
    @PostMapping(path="/addUser",consumes= {"application/json"},produces = {"application/json"})
    public User addUser(@RequestBody User user) {
        if(userService.findById(user.getId()).isEmpty()){
            return userService.addUser(user);
        }
        return new User();
    }

    @GetMapping("/getUser")
    public Optional<User> getUser(@PathParam(value = "id") Long id) {
        return userService.findById(id);
    }

    @GetMapping("/getUserByName/{name}")
    public List<User> getUserByName(@PathVariable String name) {
        return userService.findByName(name);
    }

    @GetMapping("/getAllUser")
    public List<User> getAllUser() {
        return userService.findAll();
    }
    
    
    
}

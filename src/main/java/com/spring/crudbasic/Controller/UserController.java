package com.spring.crudbasic.Controller;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.spring.crudbasic.Entity.User;
import com.spring.crudbasic.Entity.dao.ReqUser;
import com.spring.crudbasic.Entity.dao.ResUser;
import com.spring.crudbasic.Service.UserService;

import jakarta.websocket.server.PathParam;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.PutMapping;



@RestController
@RequestMapping("/User")
public class UserController {
                  
    @Autowired
    UserService userService;
    
    @PostMapping(path="/addUser",consumes= {"application/json"},produces = {"application/json"})
    public ResponseEntity<User> addUser(@RequestBody ReqUser user) {
        if(userService.findById(user.getId()).getMessage().equals("user not found")){
            return ResponseEntity.ok().body(userService.addUser(user));
        }
        return ResponseEntity.status(HttpStatus.OK).body(new User());
    }

    @GetMapping("/getUser")
    public ResponseEntity<ResUser> getUser(@PathParam(value = "id") Long id) {
        return ResponseEntity.ok().body(userService.findById(id));
    }

    @GetMapping("/getUserByName/{name}")
    public ResponseEntity<List<ResUser>> getUserByName(@PathVariable String name) {
        return ResponseEntity.ok().body(userService.findByName(name));
    }

    @GetMapping("/getAllUser")
    public ResponseEntity<List<ResUser>> getAllUser() {
        return ResponseEntity.ok().body(userService.findAll());
    }
    
    @DeleteMapping("/deleteUser/{id}")
    public ResponseEntity<ResUser> deletUser(@PathVariable Long id) {
        System.out.println(id);
        return ResponseEntity.ok().body(userService.deleteUser(id));
    }

    @DeleteMapping("/softDeleteUser/{id}")
    public ResponseEntity<ResUser> softDeletUser(@PathVariable Long id) {
        return ResponseEntity.ok().body(userService.softDeleteUser(id));
    }
    
    @PutMapping("/updateUserName/{id}")
    public ResponseEntity<ResUser> updateUserName(@PathVariable Long id,@RequestBody ReqUser reqUser) {
        return ResponseEntity.ok().body(userService.updateUserName(id,reqUser));
    }

    @PutMapping("/updateUserPlace/{id}")
    public ResponseEntity<ResUser> updateUserPlace(@PathVariable Long id,@RequestBody ReqUser reqUser) {
        return ResponseEntity.ok().body(userService.updateUserPlace(id,reqUser));
    }
}

package com.spring.crudbasic.Service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import com.spring.crudbasic.Entity.User;
import com.spring.crudbasic.Repository.UserRepository;


@Service
@Component
public class UserService {
    
    @Autowired  
    private UserRepository userRepository;  //creating JPA repository

    @Autowired
    ApplicationContext applicationContext;

    public List<User> findAll(){
        return userRepository.findAll();
    }

    public Optional<User> findById(Long id){
        return userRepository.findById(id);
    }

    public User addUser(User rqUser){
        User user = new User();
        user.setId(rqUser.getId());
        user.setName(rqUser.getName());
        user.setPassword(rqUser.getPassword());
        userRepository.save(user);
        return user;
    }

    public List<User> findByName(String name){
        return userRepository.findByName(name);
    }
}

package com.spring.crudbasic.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import com.spring.crudbasic.Entity.User;
import com.spring.crudbasic.Entity.dao.ReqUser;
import com.spring.crudbasic.Entity.dao.ResUser;
import com.spring.crudbasic.Repository.UserRepository;


@Service
@Component
public class UserService {
    
    @Autowired  
    private UserRepository userRepository;  //creating JPA repository

    @Autowired
    ApplicationContext applicationContext;

    public List<ResUser> findAll(){
        List<ResUser> resUser= new ArrayList<>();
        for(User user:userRepository.findAll()){
            resUser.add(new ResUser(user));
        }
        return resUser;
    }

    public ResUser findById(Long id){
        Optional<User> optional = userRepository.findById(id);
		ResUser userDetailRs = optional.isPresent() ? new ResUser(optional.get(),"user found") : new ResUser("user not found");
        return userDetailRs;
    }

    public User addUser(ReqUser reqUser){
        return userRepository.save(reqUser.prepareUser());
    }

    public List<ResUser> findByName(String name){
        List<ResUser> resUser= new ArrayList<>();
        for(User user:userRepository.findByName(name)){
            resUser.add(new ResUser(user));
        }
        return resUser;
    }

    public ResUser deleteUser(Long id){
        Optional<User> optional = userRepository.findById(id);
        if(optional.isPresent()){
            ResUser resUser= new ResUser(optional.get(),"user deleted sucessfully");
            userRepository.deleteById(id);
            return resUser;
            
        }
		return  new ResUser("user not found");
    }

    public ResUser softDeleteUser(Long id){
        Optional<User> optional = userRepository.findById(id);
        if(optional.isPresent()){
            ResUser resUser= new ResUser(optional.get(),"user deleted sucessfully");
            User user = optional.get();
            user.setDelete(true);
            userRepository.save(user);
            return resUser;
        }
		return  new ResUser("user not found");
    }
}

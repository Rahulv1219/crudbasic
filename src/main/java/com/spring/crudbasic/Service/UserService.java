package com.spring.crudbasic.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.stereotype.Service;

import com.spring.crudbasic.Entity.Info;
import com.spring.crudbasic.Entity.User;
import com.spring.crudbasic.Entity.dao.ReqUser;
import com.spring.crudbasic.Entity.dao.ResUser;
import com.spring.crudbasic.Repository.UserRepository;


@Service
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
        
        User user = new User();
        Info info = new Info();

        user.setId(reqUser.getId());
        user.setName(reqUser.getName());
        user.setPassword(reqUser.getPassword());
        user.setInfo(info);


        info.setId(reqUser.getId());
        info.setPlace(reqUser.getPlace());
        
        return userRepository.save(user);
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

    public ResUser updateUserName(Long id,ReqUser reqUser){
        Optional<User> optionalUser = userRepository.findById(id);
        if(optionalUser.isPresent()){
            User user = optionalUser.get();
            if(reqUser.getName().length()!=0){
                user.setName(reqUser.getName());
                return new ResUser(userRepository.save(user),"Update Sucessfully");
            }
            new ResUser("user name not empty");
        }
		return  new ResUser("user not found");
    }

        public ResUser updateUserPlace(Long id,ReqUser reqUser){
        Optional<User> optionalUser = userRepository.findById(id);
        if(optionalUser.isPresent()){
            User user = optionalUser.get();
            if(reqUser.getPlace().length()!=0){
                Info info = user.getInfo();
                info.setPlace(reqUser.getPlace());
                user.setInfo(info);
                return new ResUser(userRepository.save(user),"Update Sucessfully");
            }
            new ResUser("user place not empty");
        }
		return  new ResUser("user not found");
    }
}

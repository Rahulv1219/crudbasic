package com.spring.crudbasic.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.spring.crudbasic.Entity.dao.ReqPost;
import com.spring.crudbasic.Entity.dao.ResPost;
import com.spring.crudbasic.Service.PostService;
import com.spring.crudbasic.Service.UserService;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;


@RestController
@RequestMapping("/Post")
public class PostController {
    
    @Autowired
    PostService postService;

    @Autowired
    UserService userService;

    @PostMapping("/addPost")
    public ResPost postMethodName(@RequestBody ReqPost reqPost) {

        ResPost resPost=null;
        if(userService.findById(reqPost.getId()).getMessage().equals("User found")){
            resPost=postService.addPost(reqPost);

        }
        
        
        return resPost;
    }
    

}

package com.spring.crudbasic.Controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.spring.crudbasic.Entity.Post;
import com.spring.crudbasic.Entity.dao.ReqPost;
import com.spring.crudbasic.Entity.dao.ResPost;
import com.spring.crudbasic.Entity.dao.ResUser;
import com.spring.crudbasic.Service.PostService;
import com.spring.crudbasic.Service.UserService;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;




@RestController
@RequestMapping("/Post")
public class PostController {
    
    @Autowired
    PostService postService;

    @Autowired
    UserService userService;

    @PostMapping(path="/addNewPost",consumes= {"application/json"},produces = {"application/json"})
    public ResPost addNewPost(@RequestBody ReqPost reqPost) {

        ResPost resPost=null;
        System.out.println(reqPost.toString());
        ResUser user = userService.findById(reqPost.getId());
        System.out.println(user.getMessage());
        if((userService.findById(reqPost.getId())).getMessage().equals("user found")){
            resPost=postService.addPost(reqPost);
        }
        return resPost;
    }

    @GetMapping(path="/getAllPost",produces = {"application/json"})
    public List<Post> getAllPost() {
        return postService.fetchAllPost();
    }

    @GetMapping(path="/getPostByUser/{id}",produces = {"application/json"})
    public  Optional<Post> getMethodName(@PathVariable Long id) {
        return postService.fetchPostById(id);
    }
    
    
}

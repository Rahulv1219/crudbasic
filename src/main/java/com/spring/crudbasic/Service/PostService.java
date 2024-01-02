package com.spring.crudbasic.Service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.spring.crudbasic.Entity.Post;
import com.spring.crudbasic.Entity.dao.ReqPost;
import com.spring.crudbasic.Entity.dao.ResPost;
import com.spring.crudbasic.Repository.PostRepository;
import com.spring.crudbasic.Repository.UserRepository;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

@Service
@Component
public class PostService {
    
    @Autowired
    PostRepository postRepository;

    @Autowired
    UserRepository userRepository;

    public List<Post> fetchAllPost(){
        return postRepository.findAll();
    }

    public ResPost addPost(ReqPost reqPost){

        ResPost resPost = new ResPost();

        Post post = new Post();
        post.setId(reqPost.getId());
        post.setPostString(reqPost.getPostString());
        resPost.setPost(postRepository.save(post));

        resPost.setId(reqPost.getId());
        return resPost;
    }
}

package com.spring.crudbasic.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

import com.spring.crudbasic.Entity.Post;
import java.util.Optional;



@Repository
@Component
public interface PostRepository extends JpaRepository<Post,Long>{
    
    public Optional<Post> findById(Long id);
}

package com.spring.crudbasic.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

import com.spring.crudbasic.Entity.User;
import java.util.List;
import java.util.Optional;



@Repository
@Component
public interface UserRepository extends JpaRepository<User,Long> {

    @Query(value = "select user from User user where user.delete = false and user.name=?1")
    List<User> findByName(String name);

    @Query(value = "select user from User user where user.delete = false and user.id=?1")
    Optional<User> findById(Long id);

    @Query(value = "select user from User user where delete = false order by user.id")
    List<User> findAll();
}

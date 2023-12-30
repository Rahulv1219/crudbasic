package com.spring.crudbasic.Entity.dao;


import com.spring.crudbasic.Entity.Info;
import com.spring.crudbasic.Entity.User;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class ReqUser {

    private Long id;
    private String name;
    private String password;
    private String place;

    public User prepareUser(){

        Info info = new Info();
        info.setId(this.id);
        info.setPlace(this.place);

        User user = new User();
        user.setId(this.id);
        user.setName(this.name);
        user.setPassword(this.password);

        user.setInfo(info);

        return user;
    }
}

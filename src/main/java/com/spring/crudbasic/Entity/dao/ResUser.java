package com.spring.crudbasic.Entity.dao;

import com.spring.crudbasic.Entity.User;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@NoArgsConstructor
@ToString
@AllArgsConstructor
public class ResUser {

    private Long id;
    private String name;
    private String place;
    private String message = "User found";

    public ResUser(User user,String message){

        this.id=user.getId();
        this.name = user.getName();
        this.place = user.getInfo().getPlace();
        this.message = message;
    }

    public ResUser(String message){

        this.message = message;
    }

        public ResUser(User user){

        this.id=user.getId();
        this.name = user.getName();
        this.place = user.getInfo().getPlace();
    }

}

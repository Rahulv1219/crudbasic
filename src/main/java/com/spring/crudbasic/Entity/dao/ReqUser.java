package com.spring.crudbasic.Entity.dao;


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

}

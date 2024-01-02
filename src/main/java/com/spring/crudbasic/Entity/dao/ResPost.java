package com.spring.crudbasic.Entity.dao;

import com.spring.crudbasic.Entity.Post;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Data
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class ResPost {
    public Long id;
    public Post post;
}

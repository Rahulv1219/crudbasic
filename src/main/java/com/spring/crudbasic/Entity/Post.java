package com.spring.crudbasic.Entity;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;

import io.micrometer.common.lang.NonNull;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Entity
@Table(name = "\"Post\"")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class Post {
        
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name="Post_ID", unique=true, nullable=false, precision=20)
    private Long post_id;

    @Id
    @Column(name="id", unique=true, nullable=false, precision=20)
    private Long id;

    @NonNull
    @Column(name="post string")
    private String postString;
}

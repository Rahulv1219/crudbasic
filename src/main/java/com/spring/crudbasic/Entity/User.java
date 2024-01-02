package com.spring.crudbasic.Entity; //entity packages


import java.util.List;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import io.micrometer.common.lang.NonNull;
import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToMany;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Entity
@Table(name = "\"User\"")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class User {
    
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name="ID", unique=true, nullable=false, precision=20)
    private Long id;
  
    @NonNull
    @Column(name = "Name")
    private String name;

    @NonNull
    @Column(name = "Password")
    private String password;

    @NonNull
    @Column(name = "Delete")
    private Boolean delete=false;
    
    @OneToOne(targetEntity = Info.class,cascade = CascadeType.ALL)
    @JoinColumn(name = "info_id",referencedColumnName = "id")
    private Info info;

    @OneToMany(targetEntity = Post.class,cascade = CascadeType.ALL)
    @JoinColumn(name = "Post_ID",referencedColumnName = "id")
    private List<Post> post;

}

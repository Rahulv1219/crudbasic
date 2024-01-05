package com.spring.crudbasic.Entity; //entity packages


import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;

import io.micrometer.common.lang.NonNull;
import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.Id;
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
    @Column(name="Acess")
    private String acess;

    @NonNull
    @Column(name = "Delete")
    private Boolean delete=false;
    
    @OneToOne(cascade = {CascadeType.ALL}, fetch = FetchType.LAZY)
    private Info info;


}

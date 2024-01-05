package com.spring.crudbasic.Entity;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;

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
@Table(name = "\"Info\"")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class Info {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name="Info_Id", unique=true, nullable=false, precision=20)
    private Long id;

    @Column
    private String Place;


}

package com.spring.crudbasic.Entity;

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
    @Column(name = "ID", unique = true, nullable = false, precision = 20)
    private Long id;

    @Column
    private String Place;

}

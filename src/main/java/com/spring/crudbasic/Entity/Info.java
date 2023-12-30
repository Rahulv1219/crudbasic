package com.spring.crudbasic.Entity;

import java.security.Timestamp;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

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

    @Column(columnDefinition = "TIMESTAMP")
    private Timestamp dob;

}

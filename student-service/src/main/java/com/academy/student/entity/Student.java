package com.academy.student.entity;

import lombok.Data;
import lombok.ToString;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Data
@Entity
@ToString
@Table(name = "student")
public class Student {

    @Id
    private Integer id;
    private String name;
    private String level;
}

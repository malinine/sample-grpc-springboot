package com.academy.course.entity;

import lombok.Data;
import lombok.ToString;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Data
@Entity
@ToString
@Table(name = "course")
public class Course {

    @Id
    private String code;
    private String name;
    private String level;
}

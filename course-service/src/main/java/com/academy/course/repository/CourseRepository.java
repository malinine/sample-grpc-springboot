package com.academy.course.repository;

import com.academy.course.entity.Course;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface CourseRepository extends JpaRepository<Course, String> {
    List<Course> getCourseByLevel(String level);
}

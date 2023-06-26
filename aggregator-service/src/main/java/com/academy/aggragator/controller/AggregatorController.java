package com.academy.aggragator.controller;

import com.academy.aggragator.dto.StudentCourse;
import com.academy.aggragator.dto.StudentLevel;
import com.academy.aggragator.service.StudentCourseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class AggregatorController {

    @Autowired
    private StudentCourseService studentCourseService;

    @GetMapping("/student/{name}")
    public List<StudentCourse> getCourseByStudentName(@PathVariable String name) {
        return studentCourseService.getStudentCourse(name);
    }

    @PutMapping("/student")
    public void updateStudentLevel(@RequestBody StudentLevel studentLevel) {
        studentCourseService.updateStudentLevel(studentLevel);
    }
}

package com.academy.aggragator.service;

import com.academy.aggragator.dto.StudentCourse;
import com.academy.aggragator.dto.StudentLevel;
import com.mine.grpcacademy.common.Level;
import com.mine.grpcacademy.course.CourseSearchRequest;
import com.mine.grpcacademy.course.CourseSearchResponse;
import com.mine.grpcacademy.course.CourseServiceGrpc;
import com.mine.grpcacademy.student.StudentLevelUpdateRequest;
import com.mine.grpcacademy.student.StudentResponse;
import com.mine.grpcacademy.student.StudentSearchRequest;
import com.mine.grpcacademy.student.StudentServiceGrpc;
import net.devh.boot.grpc.client.inject.GrpcClient;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class StudentCourseService {

    @GrpcClient("student-service")
    private StudentServiceGrpc.StudentServiceBlockingStub studentStub;

    @GrpcClient("student-service")
    private StudentServiceGrpc.StudentServiceFutureStub studentServiceFutureStub;


    @GrpcClient("course-service")
    private CourseServiceGrpc.CourseServiceBlockingStub courseStub;

    public List<StudentCourse> getStudentCourse(String name) {

        StudentSearchRequest studentSearchRequest = StudentSearchRequest.newBuilder()
                                                    .setName(name).build();
        StudentResponse studentResponse = this.studentStub.getStudentLevel(studentSearchRequest);

        CourseSearchRequest courseSearchRequest = CourseSearchRequest.newBuilder()
                                                    .setLevel(studentResponse.getLevel()).build();
        CourseSearchResponse courseSearchResponse = this.courseStub.getCourseByLevel(courseSearchRequest);

        return courseSearchResponse.getCourseList()
                .stream()
                .map( courseDTO ->
                    new StudentCourse(courseDTO.getCode(), courseDTO.getName())
                ).collect(Collectors.toList());
    }

    public void updateStudentLevel(StudentLevel studentLevel){
        StudentLevelUpdateRequest studentLevelUpdateRequest = StudentLevelUpdateRequest.newBuilder()
                .setName(studentLevel.getName())
                .setLevel(Level.valueOf(studentLevel.getLevel().toUpperCase()))
                .build();
        this.studentStub.updateStudent(studentLevelUpdateRequest);
    }
}

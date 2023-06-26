package com.academy.course.service;

import com.academy.course.entity.Course;
import com.academy.course.repository.CourseRepository;
import com.mine.grpcacademy.course.CourseDTO;
import com.mine.grpcacademy.course.CourseSearchRequest;
import com.mine.grpcacademy.course.CourseSearchResponse;
import com.mine.grpcacademy.course.CourseServiceGrpc;
import io.grpc.stub.StreamObserver;
import net.devh.boot.grpc.server.service.GrpcService;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;
import java.util.stream.Collectors;

@GrpcService
public class CourseService extends CourseServiceGrpc.CourseServiceImplBase {

    @Autowired
    private CourseRepository courseRepository;

    @Override
    public void getCourseByLevel(CourseSearchRequest request, StreamObserver<CourseSearchResponse> responseObserver) {

        List<CourseDTO> courseDTOList = this.courseRepository.getCourseByLevel(request.getLevel().toString())
                .stream()
                .map(course -> CourseDTO.newBuilder()
                        .setCode(course.getCode())
                        .setName(course.getName())
                        .build())
                .collect(Collectors.toList());
        responseObserver.onNext(CourseSearchResponse.newBuilder().addAllCourse(courseDTOList).build());
        responseObserver.onCompleted();
    }
}

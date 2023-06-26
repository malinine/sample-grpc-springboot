package com.academy.student.service;

import com.academy.student.entity.Student;
import com.academy.student.repository.StudentRepository;
import com.mine.grpcacademy.common.Level;
import com.mine.grpcacademy.student.StudentLevelUpdateRequest;
import com.mine.grpcacademy.student.StudentResponse;
import com.mine.grpcacademy.student.StudentSearchRequest;
import com.mine.grpcacademy.student.StudentServiceGrpc;
import io.grpc.stub.StreamObserver;
import net.devh.boot.grpc.server.service.GrpcService;
import org.springframework.beans.factory.annotation.Autowired;

@GrpcService
public class StudentService extends StudentServiceGrpc.StudentServiceImplBase {

    @Autowired
    private StudentRepository studentRepository;

    @Override
    public void getStudentLevel(StudentSearchRequest request, StreamObserver<StudentResponse> responseObserver) {
        StudentResponse.Builder studentBuilder = StudentResponse.newBuilder();
        this.studentRepository.findByName(request.getName())
                .ifPresent(student -> {
                    studentBuilder.setId(student.getId())
                            .setName(student.getName())
                            .setLevel(Level.valueOf(student.getLevel().toUpperCase()));
                });
        responseObserver.onNext(studentBuilder.build());
        responseObserver.onCompleted();
    }

    @Override
    public void updateStudent(StudentLevelUpdateRequest request, StreamObserver<StudentResponse> responseObserver) {
        StudentResponse.Builder studentBuilder = StudentResponse.newBuilder();
        this.studentRepository.findByName(request.getName())
                .ifPresent(student -> {
                    student.setLevel(request.getLevel().toString());
                    studentBuilder.setId(student.getId())
                            .setName(student.getName())
                            .setLevel(Level.valueOf(student.getLevel().toUpperCase()));
                    this.studentRepository.save(student);
                });
        responseObserver.onNext(studentBuilder.build());
        responseObserver.onCompleted();
    }
}

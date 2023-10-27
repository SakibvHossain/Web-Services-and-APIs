package com.example.restapilab2pw.service;

import com.example.restapilab2pw.entity.Student;

import java.util.List;

public interface StudentService {
    List<Student> retrieveAllStudents();
    List<String> retrieveAllStudentNames();
    List<String> retrieveAllStudentBatch();
    List<String> retrieveAllStudentDepartment();
    List<String> retrieveAllStudentBloods();
    String retrieveStudentById(Long id);
}

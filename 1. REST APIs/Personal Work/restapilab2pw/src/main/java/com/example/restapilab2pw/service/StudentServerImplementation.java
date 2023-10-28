package com.example.restapilab2pw.service;

import com.example.restapilab2pw.entity.Student;
import com.example.restapilab2pw.repository.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

/**
 * The StudentServerImplementation class is a service implementation that retrieves student data from a
 * repository.
 */
@Service
public class StudentServerImplementation implements StudentService{
    @Autowired
    StudentRepository repository;

    @Override
    public List<Student> retrieveAllStudents() {
        return (List<Student>) repository.findAll();
    }

    @Override
    public List<String> retrieveAllStudentNames() {
        return repository.findAllName();
    }

    @Override
    public List<String> retrieveAllStudentBatch() {
        return repository.findAllBatch();
    }

    @Override
    public List<String> retrieveAllStudentDepartment() {
        return repository.findAllDepartment();
    }

    @Override
    public List<String> retrieveAllStudentBloods() {
        return repository.findAllBlood();
    }

    //We will take care of it later
    @Override
    public String retrieveStudentById(Long id) {
        Optional<String> findStudentById = Optional.ofNullable(repository.findAllNameAlsoDepartment(id));
        return findStudentById.orElseThrow(() -> new StudentNotFoundException("Student Not Found"));
    }
}

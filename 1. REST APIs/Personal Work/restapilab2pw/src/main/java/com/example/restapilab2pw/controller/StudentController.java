package com.example.restapilab2pw.controller;

import com.example.restapilab2pw.entity.Student;
import com.example.restapilab2pw.service.StudentServerImplementation;
import com.example.restapilab2pw.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * The StudentController class is a REST API controller that handles requests related to student data.
 */

@RestController
public class StudentController {
    private StudentService studentService;

    public StudentController(StudentService studentService) {
        this.studentService = studentService;
    }

    @Autowired


    @GetMapping("/students")
    public ResponseEntity<List<Student>> getAllStudents(){
        List<Student> students = studentService.retrieveAllStudents();
        return new ResponseEntity<>(students, HttpStatus.OK);
    }

    @GetMapping("/students/name")
    public ResponseEntity<List<String>> getAllStudentName(){
        List<String> names = studentService.retrieveAllStudentNames();
        return new ResponseEntity<>(names, HttpStatus.OK);
    }

    @GetMapping("/students/{id}")
    public ResponseEntity<String> getStudentNameById(@PathVariable Long id){
        String nameById = studentService.retrieveStudentById(id);
        return new ResponseEntity<String>(nameById, HttpStatus.OK);
    }

    @GetMapping("/students/batch")
    public ResponseEntity<List<String>> getStudentBatch(){
        List<String> batch = studentService.retrieveAllStudentBatch();
        return new ResponseEntity<List<String>>(batch,HttpStatus.OK);
    }
}

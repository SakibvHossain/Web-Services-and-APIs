package com.example.restapilab2pw.repository;

import com.example.restapilab2pw.entity.Student;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface StudentRepository extends CrudRepository<Student, Long> {

    @Query("select d.id, d.name, d.department from Student d where id=:id")
    String findAllNameAlsoDepartment(Long id);

    @Query("select d.id, d.name from Student d")
    List<String> findAllName();

    @Query("select d.id, d.department from Student d")
    List<String> findAllDepartment();

    @Query("select d.id, d.batch from Student d")
    List<String> findAllBatch();

    @Query("select d.id, d.blood from Student d")
    List<String> findAllBlood();

}

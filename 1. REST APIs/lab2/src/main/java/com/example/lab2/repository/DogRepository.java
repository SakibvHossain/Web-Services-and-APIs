package com.example.lab2.repository;

import com.example.lab2.entity.Dog;
import org.springframework.data.repository.CrudRepository;


public interface DogRepository extends CrudRepository<Dog, Long>{

}

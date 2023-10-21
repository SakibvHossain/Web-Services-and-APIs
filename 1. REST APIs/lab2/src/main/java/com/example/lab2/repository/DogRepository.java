package com.example.lab2.repository;

import com.example.lab2.entity.Cats;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import java.util.List;


public interface DogRepository extends CrudRepository<Cats, Long>{
    @Query("select d.id, d.breed from Cats d where d.id=:id")
    String findBreedById(Long id);

    @Query("select d.id, d.breed from Cats d")
    List<String> findAllBreed();

    @Query("select d.id, d.name from Cats d")
    List<String> findAllName();
}

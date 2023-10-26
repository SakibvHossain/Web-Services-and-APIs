package com.example.lab2.service;

import com.example.lab2.entity.Dog;

import java.util.List;

public interface DogService {
    List<Dog> retrieveDogs();
    List<String> retrieveDogBreed();
    String retrieveDogBreedById(Long id);
    List<String> retrieveDogNames();
    List<String> retrieveDogOrigin();
}

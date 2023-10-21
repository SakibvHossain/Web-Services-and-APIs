package com.example.lab2.service;

import com.example.lab2.entity.Cats;

import java.util.List;

public interface DogService {
    List<Cats> retrieveDogs();
    List<String> retrieveDogBreed();
    String retrieveDogBreedById(Long id);
    List<String> retrieveDogNames();
}

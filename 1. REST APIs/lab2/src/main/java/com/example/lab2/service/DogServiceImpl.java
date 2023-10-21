package com.example.lab2.service;

import com.example.lab2.entity.Dog;
import com.example.lab2.repository.DogRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.ExceptionHandler;

import java.util.List;
import java.util.Optional;

@Service
public class DogServiceImpl implements DogService{

    @Autowired
    DogRepository dogRepository;

    public List<Dog> retrieveDogs() {
        return (List<Dog>) dogRepository.findAll();
    }

    public List<String> retrieveDogBreed() {
        return (List<String>) dogRepository.findAllBreed();
    }

    public List<String> retrieveDogNames() {
        return (List<String>) dogRepository.findAllName();
    }

    public String retrieveDogBreedById(Long id) {
        Optional<String> optionalBreed = Optional.ofNullable(dogRepository.findBreedById(id));
        return optionalBreed.orElseThrow(() -> new DogNotFoundException("Breed not found"));
    }

}

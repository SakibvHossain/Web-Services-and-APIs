package com.example.lab2.service;

import com.example.lab2.entity.Cats;
import com.example.lab2.repository.DogRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class DogServiceImpl implements DogService{

    @Autowired
    DogRepository dogRepository;

    public List<Cats> retrieveDogs() {
        return (List<Cats>) dogRepository.findAll();
    }

    public List<String> retrieveDogBreed() {
        return (List<String>) dogRepository.findAllBreed();
    }

    public List<String> retrieveDogNames() {
        return (List<String>) dogRepository.findAllName();
    }

    public String retrieveDogBreedById(Long id) {
        Optional<String> optionalBreed = Optional.ofNullable(dogRepository.findBreedById(id));
        return optionalBreed.orElseThrow(DogNotFoundException::new);
    }

    //    public String retrieveDogBreedById(Long id) {
    //        return (String) dogRepository.findBreedById(id);
    //    }

}

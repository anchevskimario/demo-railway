package dev.mario.service.impl;

import dev.mario.entity.Animal;
import dev.mario.repository.AnimalRepository;
import dev.mario.service.CreateAnimalService;
import org.springframework.stereotype.Service;

@Service
public class CreateAnimalServiceImpl implements CreateAnimalService {

    private final AnimalRepository animalRepository;

    public CreateAnimalServiceImpl(AnimalRepository animalRepository) {
        this.animalRepository = animalRepository;
    }

    @Override
    public Long createAnimal(String name, String phrase, Integer age) {

        var animal = animalRepository.save(new Animal(name, phrase, age));

        return animal.getId();
    }
}

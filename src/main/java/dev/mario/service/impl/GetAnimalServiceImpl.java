package dev.mario.service.impl;

import dev.mario.entity.Animal;
import dev.mario.repository.AnimalRepository;
import dev.mario.service.GetAnimalService;
import org.springframework.stereotype.Service;

@Service
public class GetAnimalServiceImpl implements GetAnimalService {

    private final AnimalRepository animalRepository;

    public GetAnimalServiceImpl(AnimalRepository animalRepository) {
        this.animalRepository = animalRepository;
    }

    @Override
    public Animal getRandomAnimal(Long id) {
        return animalRepository.findById(id).get();
    }
}

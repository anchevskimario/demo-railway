package dev.mario.controller;

import dev.mario.entity.Animal;
import dev.mario.service.CreateAnimalService;
import dev.mario.service.GetAnimalService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/animals")
public class AnimalController {

    private final GetAnimalService getAnimalService;
    private final CreateAnimalService createAnimalService;

    public AnimalController(GetAnimalService getAnimalService, CreateAnimalService createAnimalService) {
        this.getAnimalService = getAnimalService;
        this.createAnimalService = createAnimalService;
    }

    @GetMapping("/{id}")
    public Animal getAnimal(@PathVariable Long id) {
        return getAnimalService.getRandomAnimal(id);
    }

    @PostMapping
    public Long createAnimal(@RequestBody Animal animal) {
        return createAnimalService.createAnimal(animal.getName(), animal.getPhrase(), animal.getAge());
    }
}

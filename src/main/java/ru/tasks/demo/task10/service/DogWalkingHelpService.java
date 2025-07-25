package ru.tasks.demo.task10.service;

import ru.tasks.demo.task10.domain.Pet;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

public interface DogWalkingHelpService {

    Optional<Pet> bookDogForWalking (List<Pet> dogs, LocalDate date);

}

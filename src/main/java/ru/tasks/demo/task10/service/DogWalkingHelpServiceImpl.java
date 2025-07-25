package ru.tasks.demo.task10.service;

import ru.tasks.demo.task10.domain.Pet;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.Optional;

public class DogWalkingHelpServiceImpl implements DogWalkingHelpService {

    private final Map<LocalDate, List<String>> dogsAndDates = new HashMap<>();
    {
        dogsAndDates.put(LocalDate.of(2025, 7, 21), new ArrayList<>());
        dogsAndDates.put(LocalDate.of(2025, 7, 22), new ArrayList<>());
    }

    @Override
    public Optional<Pet> bookDogForWalking(List<Pet> dogs, LocalDate date) {
        if (dogs.isEmpty()) return Optional.empty();
        final List<String> dogsOfDate = dogsAndDates.get(date);
        if (Objects.nonNull(dogsOfDate)) {
            return dogs.parallelStream()
                    .filter(pet -> !dogsOfDate.contains(pet.getName()))
                    .findFirst();
        } else {
            final List<String> newDogs = new ArrayList<>();
            final Pet dog = dogs.getFirst();
            newDogs.add(dog.getName());
            dogsAndDates.put(date, newDogs);
            return Optional.of(dog);
        }
    }
}

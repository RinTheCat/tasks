package ru.tasks.demo.task10.dao;

import ru.tasks.demo.task10.domain.Pet;
import ru.tasks.demo.task10.domain.PetKind;

import java.util.List;
import java.util.Optional;

public interface PetDao {

    List<Pet> getPetsAvailableForAdoption(PetKind petKind);

    Optional<Pet> getPetByName(String name);

    void savePet(Pet pet);

    List<Pet> getDogs();

}

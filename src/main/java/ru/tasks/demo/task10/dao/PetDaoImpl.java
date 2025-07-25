package ru.tasks.demo.task10.dao;

import ru.tasks.demo.task10.domain.Pet;
import ru.tasks.demo.task10.domain.PetKind;

import java.util.HashSet;
import java.util.List;
import java.util.Optional;
import java.util.Set;

public class PetDaoImpl implements PetDao {

    private final Set<Pet> petsList = new HashSet<>();
    {
        petsList.add(new Pet(PetKind.CAT, "Barsik", 1));
        petsList.add(new Pet(PetKind.RABBIT, "Fluffy", 1));
        petsList.add(new Pet(PetKind.DOG, "Druzhok", 3));
        petsList.add(new Pet(PetKind.DOG, "Vista", 5));
        petsList.add(new Pet(PetKind.DOG, "Silver", 7));
    }

    @Override
    public List<Pet> getPetsAvailableForAdoption(PetKind petKind) {
        return petsList.stream()
                .filter(pet -> !pet.isAdopted() && pet.getKind().equals(petKind))
                .toList();
    }

    @Override
    public Optional<Pet> getPetByName(String name) {
        return petsList.parallelStream()
                .filter(pet -> pet.getName().equals(name))
                .findFirst();
    }

    @Override
    public void savePet(Pet pet) {
        petsList.add(pet);
    }

    @Override
    public List<Pet> getDogs() {
        return petsList.stream()
                .filter(pet -> PetKind.DOG.equals(pet.getKind()) && !pet.isAdopted())
                .toList();
    }
}

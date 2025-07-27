package ru.tasks.demo.task10.service;

import ru.tasks.demo.task10.dao.PetDao;
import ru.tasks.demo.task10.dao.PetDaoImpl;
import ru.tasks.demo.task10.domain.Pet;
import ru.tasks.demo.task10.domain.PetKind;

import java.time.LocalDate;
import java.util.List;
import java.util.Objects;
import java.util.Optional;

public class PetServiceImpl implements PetService {

    private PetDao petDao = new PetDaoImpl();
    private DogWalkingHelpService dogWalkingHelpService = new DogWalkingHelpServiceImpl();

    @Override
    public synchronized Optional<Pet> bookDogForWalking(LocalDate date) {
        return dogWalkingHelpService.bookDogForWalking(petDao.getDogs(), date);
    }

    @Override
    public List<Pet> getPetsAvailableForAdoption(PetKind petKind) {
        return petDao.getPetsAvailableForAdoption(petKind);
    }

    @Override
    public synchronized boolean adoptPet(String name) {
        if (Objects.isNull(name)) throw new IllegalArgumentException("name should not be null");
        final Optional<Pet> pet = petDao.getPetByName(name);
        if (pet.isPresent() && !pet.get().isAdopted()) {
            pet.get().setAdopted(true);
            petDao.savePet(pet.get());
            return true;
        }
        return false;
    }

    @Override
    public boolean bringInPet(String name, int age, PetKind petKind) {
        final Pet pet = new Pet(petKind, name, age);
        petDao.savePet(pet);
        return true;
    }
}

package ru.tasks.demo.task10.service;

import ru.tasks.demo.task10.domain.Pet;
import ru.tasks.demo.task10.domain.PetKind;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

/**
 * Есть благотворительная организация, занимающаяся защитой бездомных животных.
 * Есть основные услуги, которые предоставляет огранизация:
 * - возможность "усыновить" питомца по определенным критериям
 * - возможность пристроить бездомное животное
 * - для желающих волонтеров: помощь с выгулом собак организации на добровольной основе
 *
 */
public interface PetService {

    Optional<Pet> bookDogForWalking(LocalDate date);

    List<Pet> getPetsAvailableForAdoption(PetKind petKind);

    boolean adoptPet(String name);

    boolean bringInPet(String name, int age, PetKind petKind);

}

package ru.tasks.demo.task10;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import ru.tasks.demo.task10.dao.PetDao;
import ru.tasks.demo.task10.domain.Pet;
import ru.tasks.demo.task10.domain.PetKind;
import ru.tasks.demo.task10.service.DogWalkingHelpService;
import ru.tasks.demo.task10.service.PetServiceImpl;

import static org.mockito.Mockito.verify;

@ExtendWith(MockitoExtension.class)
public class PetServiceTest {

    @Mock
    private PetDao petDaoMock;
    @Mock
    private DogWalkingHelpService dogWalkingHelpService;
    @InjectMocks
    private PetServiceImpl petService;

    @Test
    public void bringInPetTest() {
        petService.bringInPet("Yana", 1, PetKind.DOG);

        verify(petDaoMock, Mockito.times(1))
                .savePet(new Pet(PetKind.DOG, "Yana", 1));
    }
}
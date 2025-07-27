package ru.tasks.demo.task10;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.EnumSource;
import org.mockito.InOrder;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.Spy;
import org.mockito.junit.jupiter.MockitoExtension;
import ru.tasks.demo.task10.dao.PetDao;
import ru.tasks.demo.task10.domain.Pet;
import ru.tasks.demo.task10.domain.PetKind;
import ru.tasks.demo.task10.service.DogWalkingHelpService;
import ru.tasks.demo.task10.service.PetServiceImpl;

import java.time.LocalDate;
import java.util.Collections;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.inOrder;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.verifyNoInteractions;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
public class PetServiceTest {

    @Mock
    private PetDao petDaoMock;
    @Spy
    private DogWalkingHelpService dogWalkingHelpService;
    @InjectMocks
    private PetServiceImpl petService;

    @Test
    public void bringInPetTest() {
        petService.bringInPet("Yana", 1, PetKind.DOG);

        verify(petDaoMock, Mockito.times(1))
                .savePet(new Pet(PetKind.DOG, "Yana", 1));
    }

    @Test
    public void adoptPetWithNullTest() {
        assertThrows(IllegalArgumentException.class, () -> petService.adoptPet(null));
    }

    @ParameterizedTest
    @EnumSource(PetKind.class)
    public void adoptPetTest(PetKind kind) {
        when(petDaoMock.getPetByName("Yana")).thenReturn(Optional.of(new Pet(kind, "Yana", 2)));
        assertTrue(petService.adoptPet("Yana"));
        verifyNoInteractions(dogWalkingHelpService);
    }

    @Test
    public void bookDogForWalkingTest() {
        when(petDaoMock.getDogs()).thenReturn(Collections.emptyList());
        InOrder inOrder = inOrder(petDaoMock, dogWalkingHelpService);

        final Optional<Pet> result = petService.bookDogForWalking(LocalDate.now());

        inOrder.verify(petDaoMock).getDogs();
        inOrder.verify(dogWalkingHelpService).bookDogForWalking(any(), any());
        assertEquals(Optional.empty(), result);
    }
}
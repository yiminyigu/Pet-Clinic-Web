package guru.framework.sfgpetclinic.services.springdatajpa;

import guru.framework.sfgpetclinic.model.Owner;
import guru.framework.sfgpetclinic.repositories.OwnerRepository;
import guru.framework.sfgpetclinic.repositories.PetRepository;
import guru.framework.sfgpetclinic.repositories.PetTypeRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class OwnerSDJpaServiceTest {

    @Mock
    OwnerRepository ownerRepository;
    @Mock
    PetRepository petRepository;
    @Mock
    PetTypeRepository petTypeRepository;

    @InjectMocks
    OwnerSDJpaService ownerSDJpaService;

    Owner returnOwner;

    @BeforeEach
    void setUp() {
        returnOwner=Owner.builder().id(1L).lastName("smith").build();
    }

    @Test
    void findByLastName() {


        when(ownerRepository.findByLastName((any()))).thenReturn(returnOwner);

        Owner smith=ownerSDJpaService.findByLastName("smith");

        assertEquals("smith",smith.getLastName());

        verify(ownerRepository).findByLastName(any());
    }

    @Test
    void findAll() {
    }

    @Test
    void findById() {
    }

    @Test
    void save() {
    }

    @Test
    void delete() {
    }

    @Test
    void deleteById() {
    }
}
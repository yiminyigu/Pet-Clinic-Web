package guru.framework.sfgpetclinic.services.map;

import guru.framework.sfgpetclinic.model.Owner;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Set;

import static org.junit.jupiter.api.Assertions.assertEquals;

class abstractMapServiceTest {

    abstractMapService<Owner,Long> abstractMapService;
    final long ownerid=1L;

    @BeforeEach
    void setUp() {
        abstractMapService=new OwnerServiceMap(new PetTypeServiceMap(),new PetServiceMap());
        abstractMapService.save(Owner.builder().id(1L).build());
    }

    @Test
    void findAll() {

        Set<Owner> owners=abstractMapService.findAll();

        assertEquals(1L,owners.size());
    }

    @Test
    void findById() {
        Owner owner=abstractMapService.findById(ownerid);

        assertEquals(ownerid,owner.getId());

    }

    @Test
    void save() {
    }

    @Test
    void deleteById() {
        abstractMapService.deleteById((ownerid));
        assertEquals(0,abstractMapService.findAll().size());
    }

    @Test
    void delete() {
        abstractMapService.delete(abstractMapService.findById(ownerid));
        assertEquals(0,abstractMapService.findAll().size());
    }
}
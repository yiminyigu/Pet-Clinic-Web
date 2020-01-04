package guru.framework.sfgpetclinic.services.map;

import guru.framework.sfgpetclinic.model.Owner;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

class OwnerServiceMapTest {

    OwnerServiceMap ownerServiceMap;

    final String lastName="lastName";
    final Long ownerid=1L;

    @BeforeEach
    void setUp() {
        ownerServiceMap=new OwnerServiceMap(new PetTypeServiceMap(),new PetServiceMap());
        ownerServiceMap.save(Owner.builder().id(ownerid).lastName(lastName).build());
    }

    @Test
    void findByLastName() {
        Owner owner=ownerServiceMap.findByLastName(lastName);
        assertNotNull(owner);

        assertEquals(ownerid,owner.getId());
    }



    @Test
    void saveExistingId() {
        long id =2L;
        Owner owner2=Owner.builder().id(id).build();
        Owner savedOwner=ownerServiceMap.save(owner2);
        assertEquals(id,savedOwner.getId());
    }

    @Test
    void saveENoId() {

        Owner savedOwner=ownerServiceMap.save(Owner.builder().build());
        assertNotNull(savedOwner);
        assertNotNull(savedOwner.getId());
    }
}
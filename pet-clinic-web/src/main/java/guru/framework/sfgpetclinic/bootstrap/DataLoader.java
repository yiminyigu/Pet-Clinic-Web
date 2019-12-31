package guru.framework.sfgpetclinic.bootstrap;

import guru.framework.sfgpetclinic.model.Owner;
import guru.framework.sfgpetclinic.model.PetType;
import guru.framework.sfgpetclinic.model.Vet;
import guru.framework.sfgpetclinic.services.OwnerService;
import guru.framework.sfgpetclinic.services.PetTypeService;
import guru.framework.sfgpetclinic.services.VetService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class DataLoader implements CommandLineRunner {

    private final OwnerService ownerService;
    private final VetService vetService;
    private final PetTypeService petTypeService;

    @Autowired//constructor do not need it
    public DataLoader(OwnerService ownerService, VetService vetService, PetTypeService petTypeService) {
        this.ownerService = ownerService;
        this.vetService = vetService;
        this.petTypeService = petTypeService;
    }

    @Override
    public void run(String... args) throws Exception {
        PetType dog =new PetType();
        dog.setName("dog");
        PetType savedDogPetType =petTypeService.save(dog);

        PetType cat =new PetType();
        cat.setName("cat");
        PetType savedCatPetType =petTypeService.save(cat);

        Owner owner1=new Owner();

        owner1.setFirstName("Michael");
        owner1.setLastName("Weston");

        ownerService.save(owner1);

        Owner owner2=new Owner();
        owner2.setFirstName("Fiona");
        owner2.setLastName("Glenanne");

        ownerService.save(owner2);

        System.out.println("Loaded Owners...");

        Vet vet1=new Vet();

        vet1.setFirstName("Sam");
        vet1.setLastName("Asc");

        Vet vet2=new Vet();
        vet2.setFirstName("Jessie");
        vet2.setLastName("Porter");

        vetService.save(vet1);
        vetService.save(vet2);
        System.out.println("Loaded Vets...");








    }
}

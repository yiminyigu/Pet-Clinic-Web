package guru.framework.sfgpetclinic.bootstrap;

import guru.framework.sfgpetclinic.model.Owner;
import guru.framework.sfgpetclinic.model.Pet;
import guru.framework.sfgpetclinic.model.PetType;
import guru.framework.sfgpetclinic.model.Vet;
import guru.framework.sfgpetclinic.services.OwnerService;
import guru.framework.sfgpetclinic.services.PetTypeService;
import guru.framework.sfgpetclinic.services.VetService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.time.LocalDate;

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
        owner1.setAddress("1223 Brickerel");
        owner1.setCity("Miami");
        owner1.setTelephone("67390851");


        Pet mikesPet = new Pet();
        mikesPet.setPetType(savedDogPetType);
        mikesPet.setOwner(owner1);
        mikesPet.setBirthDate(LocalDate.now());
        mikesPet.setName("Rock");
        owner1.getPets().add(mikesPet);
        ownerService.save(owner1);

        Owner owner2=new Owner();
        owner2.setFirstName("Fiona");
        owner2.setLastName("Glenanne");
        owner2.setAddress("1223 Brickerel");
        owner2.setCity("Miami");
        owner2.setTelephone("67390851");

        Pet fionasCat = new Pet();
        fionasCat.setPetType(savedCatPetType);
        fionasCat.setOwner(owner2);
        fionasCat.setBirthDate(LocalDate.now());
        fionasCat.setName("Just Cat");
        owner2.getPets().add(fionasCat);
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

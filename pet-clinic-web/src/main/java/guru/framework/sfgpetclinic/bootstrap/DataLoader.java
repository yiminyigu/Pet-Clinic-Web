package guru.framework.sfgpetclinic.bootstrap;

import guru.framework.sfgpetclinic.model.*;
import guru.framework.sfgpetclinic.services.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.time.LocalDate;

@Component
public class DataLoader implements CommandLineRunner {

    private final OwnerService ownerService;
    private final VetService vetService;
    private final PetTypeService petTypeService;
    private final SpecialitiesService specialitiesService;
    private final VisitService visitService;

    @Autowired//constructor do not need it
    public DataLoader(OwnerService ownerService, VetService vetService, PetTypeService petTypeService, SpecialitiesService specialitiesService, VisitService visitService) {
        this.ownerService = ownerService;
        this.vetService = vetService;
        this.petTypeService = petTypeService;
        this.specialitiesService = specialitiesService;
        this.visitService = visitService;
    }




    @Override
    public void run(String... args) throws Exception {
        int count = petTypeService.findAll().size();
        if (count==0){
            loadData();
        }


    }

    private void loadData() {
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

        Visit catVisit = new Visit();
        catVisit.setPet(fionasCat);
        catVisit.setDate(LocalDate.now());
        catVisit.setDescription("Sneezy Kitty");

        visitService.save(catVisit);
        System.out.println("Loaded Owners...");

        Speciality radiology=new Speciality();
        radiology.setDescription("radiology");
        Speciality savedRadiology = specialitiesService.save(radiology);

        Speciality surgery=new Speciality();
        surgery.setDescription("surgery");
        Speciality savedSurgery = specialitiesService.save(surgery);

        Speciality dentistry=new Speciality();
        dentistry.setDescription("dentistry");
        Speciality savedDentistry = specialitiesService.save(dentistry);

        Vet vet1=new Vet();

        vet1.setFirstName("Sam");
        vet1.setLastName("Asc");
        vet1.getSpecialities().add(savedRadiology);
        vet1.getSpecialities().add(savedDentistry);
        Vet vet2=new Vet();
        vet2.setFirstName("Jessie");
        vet2.setLastName("Porter");
        vet2.getSpecialities().add(savedDentistry);

        Vet vet3=new Vet();
        vet3.setFirstName("somefirst");
        vet3.setLastName("somesecond");
        vet3.getSpecialities().add(savedSurgery);
        vetService.save(vet2);
        vetService.save(vet1);
        vetService.save(vet3);
        System.out.println("Loaded Vets...");
    }
}

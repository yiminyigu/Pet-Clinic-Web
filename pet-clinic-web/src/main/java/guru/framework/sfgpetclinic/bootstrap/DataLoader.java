package guru.framework.sfgpetclinic.bootstrap;

import guru.framework.sfgpetclinic.model.Owner;
import guru.framework.sfgpetclinic.model.Vet;
import guru.framework.sfgpetclinic.services.OwnerService;
import guru.framework.sfgpetclinic.services.VetService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class DataLoader implements CommandLineRunner {

    private final OwnerService ownerService;
    private final VetService vetService;

    @Autowired//constructor do not need it
    public DataLoader(OwnerService ownerService, VetService vetService) {
        this.ownerService = ownerService;
        this.vetService = vetService;
    }

    @Override
    public void run(String... args) throws Exception {
        Owner owner1=new Owner();

        owner1.setFirstName("Michael");
        owner1.setLastName("Weston");

        ownerService.save(owner1);

        System.out.println("Loaded Owners...");

        Vet vet1=new Vet();

        vet1.setFirstName("Sam");
        vet1.setLastName("Asc");

        vetService.save(vet1);
        System.out.println("Loaded Vets...");








    }
}

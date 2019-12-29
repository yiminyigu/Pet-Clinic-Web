package guru.framework.sfgpetclinic.bootstrap;

import guru.framework.sfgpetclinic.model.Owner;
import guru.framework.sfgpetclinic.model.Vet;
import guru.framework.sfgpetclinic.services.OwnerService;
import guru.framework.sfgpetclinic.services.VetService;
import guru.framework.sfgpetclinic.services.map.OwnerServiceMap;
import guru.framework.sfgpetclinic.services.map.VetServiceMap;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class DataLoader implements CommandLineRunner {

    private final OwnerService ownerService;
    private final VetService vetService;

    public DataLoader() {
        this.ownerService=new OwnerServiceMap();
        this.vetService=new VetServiceMap();
    }



    @Override
    public void run(String... args) throws Exception {
        Owner owner1=new Owner();
        owner1.setId(1L);
        owner1.setFirstName("Michael");
        owner1.setLastName("Weston");

        ownerService.save(1L , owner1);

        System.out.println("Loaded Owners...");

        Vet vet1=new Vet();
        vet1.setId(3L);
        vet1.setFirstName("Sam");
        vet1.setLastName("Asc");

        vetService.save(3L,vet1);
        System.out.println("Loaded Vets...");








    }
}

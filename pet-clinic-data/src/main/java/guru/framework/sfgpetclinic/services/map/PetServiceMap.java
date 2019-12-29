package guru.framework.sfgpetclinic.services.map;

import guru.framework.sfgpetclinic.model.Pet;
import guru.framework.sfgpetclinic.services.PetService;
import org.springframework.stereotype.Service;


@Service
public class PetServiceMap extends abstractMapService<Pet, Long> implements PetService {
}

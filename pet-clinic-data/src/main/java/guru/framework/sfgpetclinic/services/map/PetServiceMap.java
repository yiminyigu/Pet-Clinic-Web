package guru.framework.sfgpetclinic.services.map;

import guru.framework.sfgpetclinic.model.Pet;
import guru.framework.sfgpetclinic.services.PetService;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Service;


@Service
@Profile({"default","map"})
public class PetServiceMap extends abstractMapService<Pet, Long> implements PetService {
}

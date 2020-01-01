package guru.framework.sfgpetclinic.services.map;

import guru.framework.sfgpetclinic.model.PetType;
import guru.framework.sfgpetclinic.services.PetTypeService;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Service;

@Service
@Profile({"default","map"})
public class PetTypeServiceMap extends abstractMapService<PetType,Long> implements PetTypeService {
}

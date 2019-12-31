package guru.framework.sfgpetclinic.services.map;

import guru.framework.sfgpetclinic.model.PetType;
import guru.framework.sfgpetclinic.services.PetTypeService;
import org.springframework.stereotype.Service;

@Service
public class PetTypeServiceMap extends abstractMapService<PetType,Long> implements PetTypeService {
}

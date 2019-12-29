package guru.framework.sfgpetclinic.services.map;

import guru.framework.sfgpetclinic.model.Vet;
import guru.framework.sfgpetclinic.services.VetService;
import org.springframework.stereotype.Service;


@Service
public class VetServiceMap extends abstractMapService<Vet,Long> implements VetService {
}

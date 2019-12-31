package guru.framework.sfgpetclinic.services.map;

import guru.framework.sfgpetclinic.model.Speciality;
import guru.framework.sfgpetclinic.services.SpecialitiesService;
import org.springframework.stereotype.Service;

@Service
public class SpecialitiesServiceMap extends abstractMapService<Speciality,Long> implements SpecialitiesService {
}

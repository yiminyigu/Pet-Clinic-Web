package guru.framework.sfgpetclinic.services.map;

import guru.framework.sfgpetclinic.model.Vet;
import guru.framework.sfgpetclinic.services.SpecialitiesService;
import guru.framework.sfgpetclinic.services.VetService;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Service;


@Service
@Profile({"default","map"})
public class VetServiceMap extends abstractMapService<Vet,Long> implements VetService {
    private final SpecialitiesService specialitiesService;

    public VetServiceMap(SpecialitiesService specialitiesService) {
        this.specialitiesService = specialitiesService;
    }

    @Override
    public Vet save(Vet object) {
        if (object.getSpecialities().size()>0){
            object.getSpecialities().forEach(speciality -> {
                if(speciality.getId()==null){
                    speciality.setId(specialitiesService.save(speciality).getId());
                }
            });
        }
        return super.save(object);
    }
}

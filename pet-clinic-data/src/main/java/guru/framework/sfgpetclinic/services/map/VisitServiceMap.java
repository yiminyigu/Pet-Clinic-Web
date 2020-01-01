package guru.framework.sfgpetclinic.services.map;

import guru.framework.sfgpetclinic.model.Visit;
import guru.framework.sfgpetclinic.services.VisitService;

public class VisitServiceMap extends abstractMapService<Visit,Long> implements VisitService {

    @Override
    public Visit save(Visit visit) {

        if(visit.getPet() == null || visit.getPet().getOwner() == null || visit.getPet().getId() == null
                || visit.getPet().getOwner().getId() == null){
            throw new RuntimeException("Invalid Visit");
        }

        return super.save(visit);
    }
}

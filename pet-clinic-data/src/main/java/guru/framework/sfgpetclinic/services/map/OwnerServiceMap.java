package guru.framework.sfgpetclinic.services.map;

import guru.framework.sfgpetclinic.model.Owner;
import guru.framework.sfgpetclinic.services.OwnerService;
import org.springframework.stereotype.Service;

@Service
public class OwnerServiceMap extends abstractMapService<Owner,Long> implements OwnerService {

    @Override
    public Owner findByLastName(String lastName) {
        return null;
    }
}

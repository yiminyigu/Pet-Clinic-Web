package guru.framework.sfgpetclinic.services;

import guru.framework.sfgpetclinic.model.Owner;

import java.util.List;

public interface OwnerService extends CrudService<Owner,Long>{

    Owner findByLastName(String lastName);

    List<Owner> findAllByLastNameLike(String lastName);

}

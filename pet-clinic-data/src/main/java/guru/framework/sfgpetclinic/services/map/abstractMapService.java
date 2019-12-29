package guru.framework.sfgpetclinic.services.map;

import guru.framework.sfgpetclinic.model.BaseEntity;
import guru.framework.sfgpetclinic.services.CrudService;

import java.util.*;

public abstract class abstractMapService<T extends BaseEntity,ID extends Long> implements CrudService<T,Long> {

    public Set<T> findAll(){
        return new HashSet<>(map.values());
    }

    public T findById(ID id){
        return map.get(id);
    }

    public T save(T object){
        if(object!=null){
            if(object.getId()==null){
                object.setId(getNextId());
            }
            map.put(object.getId(),object);
        }else{
            throw new RuntimeException("Object cannot be null!");
        }
        return object;

    }

    public void deleteById(ID id){
        map.remove(id);
    }

    public void delete(T object){
        map.entrySet().removeIf(entry->entry.getValue().equals(object));
    }

    protected Map<Long,T> map=new HashMap<Long,T>();

    private Long getNextId(){
        if(map.isEmpty()){
            return 1L;
        }
        return Collections.max(map.keySet())+1;
    }
}

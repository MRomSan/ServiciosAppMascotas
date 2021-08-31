package es.itm.dao;

import es.itm.model.Tipo;
import java.util.List;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.Repository;

public interface TipoRepository extends Repository<Tipo, Integer> {
    List<Tipo> findAll();
    Tipo findById(int id);
    Tipo save(Tipo t);
    void deleteById(int id);
    long count();
    Boolean existsByNombre(String nombre);
    
    @Query("select t from Tipo t where t in (select distinct(m.tipo) from Mascota m)")
    List<Tipo> findAllInUse();
}

package es.itm.dao;

import es.itm.model.Mascota;
import java.util.List;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.Repository;

public interface MascotaRepository extends Repository<Mascota, Integer>{
    List<Mascota> findAll();
    Mascota findById(int id);
    Mascota save(Mascota m);
    void deleteById(int id);
    
    @Query("select m from Mascota m where m.venta is null")
    List<Mascota> findAllNotSold();
    
    @Query("select m from Mascota m where m.venta is not null")
    List<Mascota> findAllSold();
}

package es.itm.dao;

import es.itm.model.Venta;
import java.util.List;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.Repository;

public interface VentaRepository extends Repository<Venta, String>{
    List<Venta> findAll();
    Venta findById(String id);
    Venta save(Venta v);
    
    @Query("select max(v.id_venta) from Venta v")
    String getMaxID();
}

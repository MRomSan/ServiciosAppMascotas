package es.itm.dao;

import es.itm.model.Venta;
import java.util.List;
import org.springframework.data.repository.Repository;

public interface VentaRepository extends Repository<Venta, Integer>{
    List<Venta> findAll();
    Venta findById(int id);
    Venta save(Venta v);
}

package es.itm.dao;

import es.itm.model.Cliente;
import java.util.List;
import org.springframework.data.repository.Repository;

public interface ClienteRepository extends Repository<Cliente, String>{
    List<Cliente> findAll();
    Cliente findById(String id);
    Cliente save(Cliente c);
    void deleteById(String id);
}

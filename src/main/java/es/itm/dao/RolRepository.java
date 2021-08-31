package es.itm.dao;

import es.itm.model.ERol;
import es.itm.model.Rol;
import java.util.Optional;
import org.springframework.data.repository.Repository;

public interface RolRepository extends Repository<Rol, Long>{
    Optional<Rol> findByNombre(ERol nombre);
}

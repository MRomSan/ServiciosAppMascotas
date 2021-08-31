package es.itm.dao;

import es.itm.model.Usuario;
import java.util.List;
import java.util.Optional;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.Repository;

public interface UsuarioRepository extends Repository<Usuario, Long> {
    List<Usuario> findAll();
    Usuario findById(Long id);
    Optional<Usuario> findByUsername(String username);
    Usuario save(Usuario e);
    Boolean existsByUsername(String username);
    
    @Modifying
    @Query("update Usuario u set alta=false where u.id_usuario = ?1")
    Integer bajaEmpleado(Long id);
    
    @Query("select max(id_usuario) from Usuario u")
    Long maxId_usuario();
    
    @Query("select alta from Usuario u where u.username like ?1")
    Boolean usuarioEnAlta(String id);
    
    @Query("select u from Usuario u join u.roles r where u.alta=true and r.nombre like 'ROLE_USER'")
    List<Usuario> findAllEnAlta();
}

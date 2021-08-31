package es.itm.service;

import es.itm.dao.RolRepository;
import es.itm.model.Usuario;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import es.itm.dao.UsuarioRepository;
import es.itm.model.ERol;
import es.itm.model.Rol;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.transaction.annotation.Transactional;

@Service
public class UsuarioServiceImpl implements UsuarioService{
    @Autowired
    private UsuarioRepository empRep;
    
    @Autowired
    private RolRepository rolRep;
    
    @Autowired
    private PasswordEncoder encoder;
    
    @Override
    public List<Usuario> listadoEmpleados() {
        return empRep.findAll();
    }

    @Override
    public Usuario devuelveEmpleado(Long id) {
        return empRep.findById(id);
    }

    @Override
    public Usuario nuevoEmpleado(Usuario e) {
        e.setId_usuario(empRep.maxId_usuario() + 1);
        
        Set<Rol> roles = new HashSet<>();
        Rol userRole = rolRep.findByNombre(ERol.ROLE_USER)
                .orElseThrow(() -> new RuntimeException("Error: Rol no econtrado."));;
        roles.add(userRole);
        e.setRoles(roles);
        
        e.setPassword(encoder.encode(e.getPassword()));
        
        return empRep.save(e);
    }
    
    @Override
    @Transactional
    public List<Usuario> bajaEmpleado(String ids) {
        List<String> idsEmpleados = Arrays.asList(ids.split("\\s*,\\s*"));
        List<Usuario> empleados = new ArrayList<>();
        for (String idEmpleado : idsEmpleados) {
            long id = Long.parseLong(idEmpleado);
            if(empRep.bajaEmpleado(id)!=0) {
                empleados.add(empRep.findById(id));
            }
        }
        return empleados;
    }

    @Override
    public Usuario modificarEmpleado(Usuario e) {
        return empRep.save(e);
    }

    @Override
    public Boolean existsEmpleado(String username) {
        return empRep.existsByUsername(username);
    }

    @Override
    public List<Usuario> listadoEmpleadosDeAlta() {
        return empRep.findAllEnAlta();
    }

    @Override
    public Usuario newPassword(String newPassword, Long id) {
        Usuario e = empRep.findById(id);
        e.setPassword(encoder.encode(newPassword));
        return empRep.save(e);
    }

}

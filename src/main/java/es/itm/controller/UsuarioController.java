package es.itm.controller;

import es.itm.model.Usuario;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import es.itm.service.UsuarioService;
import org.springframework.security.access.prepost.PreAuthorize;

@CrossOrigin(origins="http://localhost:4200", maxAge=3600)
@RestController
@RequestMapping
public class UsuarioController {
    @Autowired
    UsuarioService usuService;
    
    @GetMapping("/empleados")
    @PreAuthorize("hasRole('ADMIN')")
    public List<Usuario> listarEmpleados() {
        return usuService.listadoEmpleados();
    }
    
    @GetMapping("/empleado/{id}")
    @PreAuthorize("hasRole('USER') or hasRole('ADMIN')")
    public Usuario empleadoById(@PathVariable("id") Long id) {
        return usuService.devuelveEmpleado(id);
    }
    
    @PostMapping("/empleado/{pass}")
    @PreAuthorize("hasRole('ADMIN')")
    public Usuario crearNuevoEmpleado(@PathVariable("pass") String pass, @RequestBody Usuario e) {
        e.setPassword(pass);
        return usuService.nuevoEmpleado(e);
    }
    
    @PutMapping("/empleado/{id}")
    @PreAuthorize("hasRole('ADMIN')")
    public Usuario modificarEmpleado(@RequestBody Usuario e, @PathVariable("id") Long id) {
        e.setId_usuario(id);
        e.setPassword(usuService.devuelveEmpleado(id).getPassword());
        return usuService.modificarEmpleado(e);
    }
    
    @PutMapping("/empleado/newpassword/{id}")
    @PreAuthorize("hasRole('ADMIN')")
    public Usuario modificarPassword(@RequestBody String newPassword, @PathVariable("id") Long id) {
        return usuService.newPassword(newPassword, id);
    }
    
    @PutMapping("/empleado/baja")
    @PreAuthorize("hasRole('ADMIN')")
    public List<Usuario> darBajaEmpleados(@RequestBody String ids) {
        return usuService.bajaEmpleado(ids);
    }
    
    @GetMapping("/empleado/username/{username}")
    @PreAuthorize("hasRole('ADMIN')")
    public boolean existeUsuario(@PathVariable("username") String username) {
        return usuService.existsEmpleado(username);
    }
    
    @GetMapping("/empleados/alta")
    @PreAuthorize("hasRole('ADMIN')")
    public List<Usuario> listarEmpleadosDeAlta() {
        return usuService.listadoEmpleadosDeAlta();
    }
}
